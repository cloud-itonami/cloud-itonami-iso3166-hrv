(ns marketentry.governor
  "Market-Entry Compliance Governor -- the independent compliance layer
  that earns the MarketEntry-LLM the right to commit. The LLM has no
  notion of jurisdictional procurement law, whether a Croatian foreign-
  investment-approval application has actually been filed with
  Ministarstvo financija BEFORE a sudski registar filing for an
  engagement that requires one, whether a claimed engagement fee
  actually equals base + months x rate, or when a draft stops being a
  draft and becomes a real-world EOJN RH portal submission, so this
  MUST be a separate system able to *reject* a proposal and fall back
  to HOLD.

  `:itonami.blueprint/governor` is `:market-entry-compliance-governor`
  (shared family keyword on blueprints; this fleet's Poland
  implementation was the first *running* instance of this governor
  for the iso3166 family, Serbia the second, Slovenia the third; this
  is Croatia's).

  This blueprint's own text (docs/business-model.md Trust Controls:
  'any actual EOJN RH registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off'; 'a false or fabricated regulatory-requirement claim
  is a HARD hold') names exactly the checks below.

  Croatia is an EU MEMBER STATE (eurozone since 2023, Schengen since
  2023) -- like Poland and Slovenia, NOT like Serbia (EU-candidate,
  non-member). But Croatia's own distinguishing structural fact,
  independently fetched and read this session from THREE separate
  official sources (zakon.hr's full consolidated text, the primary
  narodne-novine.nn.hr gazette publication, and mfin.gov.hr's own
  explanatory notice), is NOT the same as any sibling's:

    - Poland's flagship pair (`eu-establishment-missing` +
      `nip-unverified`) is grounded in EU freedom-of-establishment/
      authorized-representative practice for procurement plus Poland's
      own NIP/KRS numbers -- no FDI-screening check in that blueprint.
    - Slovenia's flagship (`fdi-notification-missing`) is grounded in
      the Zakon o spodbujanju investicij (ZSInv), an amended-in-place
      2013-era law, administered by Ministrstvo za gospodarstvo, delo
      in šport (Ministry of ECONOMY, Labour and Sport).
    - Serbia's flagship (`nonresident-pib-missing`) is grounded in Art.
      26 Zakon o poreskom postupku i poreskoj administraciji; Serbia's
      own README explicitly discloses NO FDI-screening regime at all
      (Zakon o ulaganjima gives foreign investors national treatment
      with no notification threshold).

  Croatia instead has a BRAND-NEW, standalone, single-purpose national
  FDI-screening statute -- the Zakon o provjeri stranih ulaganja (Act
  on the Verification of Foreign Investments), Narodne novine 136/2025,
  IN FORCE ONLY SINCE 13 NOVEMBER 2025 -- administered by Ministarstvo
  financija (Ministry of FINANCE, not Economy: a genuinely different
  institutional home from Slovenia's), whose own explanatory notice
  states its adoption 'ispunjen je jedan od kriterija za pristup
  Republike Hrvatske OECD-u' (fulfils one of the criteria for Croatia's
  OECD accession) -- a policy driver that has no analogue in either
  sibling's story. Structurally, this law is ALSO the FIRST of this
  fleet's FDI-screening flagships to be procedurally interlocked with
  the SAME sudski-registar-filing fact this actor's own required-
  evidence checklist already tracks: Čl. 6(3) defines a 'completed'
  foreign investment as one for which the competent commercial court
  has carried out the sudski registar entry; Čl. 11(1)(a) names that
  SAME 'nadležni trgovački sud' as a statutory 'kontrolno tijelo'
  (control body) which, per Čl. 11(3), acts ex officio to prevent
  completion of an unreported foreign investment; and Čl. 12(3)
  requires the foreign-investment-approval application to be filed
  with Ministarstvo financija at the latest BEFORE the sudski registar
  registration application itself is filed. Slovenia's ZSInv ties
  notification to 'commencing business activity' generally; Croatia's
  ZPSU ties it to the exact same registry-filing moment this actor's
  own evidence checklist already gates on -- a distinct, independently
  verified structural fact, not a copy of Slovenia's shape. Adding a
  fabricated eu-establishment/NIP-style pair or a copy-pasted PIB/
  ZSInv-shaped check here, without this law's OWN article-level hook,
  would have been dishonest; a smaller, single, genuinely grounded
  check is preferred. See `marketentry.facts` docstring for the
  complete citation trail.

  Six checks, in priority order, ALL HARD violations: a human approver
  CANNOT override them. The confidence/actuation gate is SOFT: it asks
  a human to look (low confidence / actuation), and the human may
  approve -- but see `marketentry.phase`: for `:stake
  :actuation/draft-filing`/`:actuation/submit-filing` NO phase ever
  allows auto-commit either. Two independent layers agree that
  actuation is always a human call.

    1. Spec-basis                       -- did the jurisdiction
                                            proposal cite an OFFICIAL
                                            source (`marketentry.facts`),
                                            or invent one?
    2. Evidence incomplete              -- for `:filing/draft`/
                                            `:filing/submit`, has the
                                            jurisdiction actually been
                                            assessed with a full
                                            evidence checklist on file?
    3. Foreign-investment approval      -- for `:filing/submit`, when
       missing                             the engagement declares
                                            `:requires-foreign-investment-approval?
                                            true`, INDEPENDENTLY verify
                                            `:foreign-investment-approval-verified?`
                                            is true. FLAGSHIP check for
                                            this vertical, grounded in
                                            the Zakon o provjeri stranih
                                            ulaganja (NN 136/2025) Čl.
                                            6(11)/11(1)(a)/11(3)/12(3).
    4. Engagement fee mismatch          -- for `:filing/submit`,
                                            INDEPENDENTLY recompute
                                            whether the engagement's own
                                            `:claimed-fee` equals
                                            `base-fee + monthly-rate x
                                            monitoring-months` -- honest
                                            reapplication of the
                                            ground-truth-recompute
                                            discipline sibling actors
                                            use.
    5/6. Double-draft / double-submit prevention -- enforced off
                                            dedicated `:drafted?`/
                                            `:submitted?` facts (never a
                                            `:status` value)."
  (:require [marketentry.facts :as facts]
            [marketentry.registry :as registry]
            [marketentry.store :as store]))

(def confidence-floor 0.6)

(def high-stakes
  "Stakes grave enough to always require a human, even when clean.
  Drafting a real EOJN RH filing package and submitting a real portal
  registration are the two real-world actuation events this actor
  performs."
  #{:actuation/draft-filing :actuation/submit-filing})

;; ----------------------------- checks -----------------------------

(defn- spec-basis-violations
  "A `:jurisdiction/assess` (or `:filing/draft`/`:filing/submit`)
  proposal with no spec-basis citation is a HARD violation -- never
  invent a jurisdiction's market-entry requirements."
  [{:keys [op]} proposal]
  (when (contains? #{:jurisdiction/assess :filing/draft :filing/submit} op)
    (let [value (:value proposal)]
      (when (or (empty? (:cites proposal))
                (and (contains? value :spec-basis) (nil? (:spec-basis value))))
        [{:rule :no-spec-basis
          :detail "公式spec-basisの引用が無い提案は法域要件として扱えない"}]))))

(defn- evidence-incomplete-violations
  "For `:filing/draft`/`:filing/submit`, the jurisdiction's required
  registration evidence must actually be satisfied."
  [{:keys [op subject]} st]
  (when (contains? #{:filing/draft :filing/submit} op)
    (let [e (store/engagement st subject)
          assessment (store/assessment-of st subject)]
      (when-not (and assessment
                     (facts/required-evidence-satisfied?
                      (:jurisdiction e) (:checklist assessment)))
        [{:rule :evidence-incomplete
          :detail "法域の必要書類(Sudski registar登録/OIB/EOJN RH登録/署名権限者確認等)が充足していない状態での提案"}]))))

(defn- foreign-investment-approval-missing-violations
  "For `:filing/submit`, when the engagement declares
  `:requires-foreign-investment-approval? true`, INDEPENDENTLY verify
  `:foreign-investment-approval-verified?` is true -- the flagship
  genuinely new check this vertical adds. CONDITIONAL on the
  engagement's own `:requires-foreign-investment-approval?` ground
  truth. Grounded in the Zakon o provjeri stranih ulaganja (NN
  136/2025), Čl. 6(11) [10% kvalificirani udio threshold], Čl. 11(1)(a)
  + Čl. 11(3) [nadležni trgovački sud as kontrolno tijelo preventing
  completion of an unreported investment], and Čl. 12(3) [approval
  application due at Ministarstvo financija before the sudski registar
  filing itself]."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (let [e (store/engagement st subject)]
      (when (and (true? (:requires-foreign-investment-approval? e))
                 (not (true? (:foreign-investment-approval-verified? e))))
        [{:rule :foreign-investment-approval-missing
          :detail (str subject " は外国投資審査承認(Zakon o provjeri stranih ulaganja/EU規則2019/452)確認を要するが未確認 -- 提出提案は進められない")}]))))

(defn- engagement-fee-mismatch-violations
  "For `:filing/submit`, INDEPENDENTLY recompute whether the
  engagement's own claimed fee equals base + months x rate."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (let [e (store/engagement st subject)]
      (when-not (registry/engagement-fee-matches-claim? e)
        [{:rule :engagement-fee-mismatch
          :detail (str subject " の申告手数料(" (:claimed-fee e)
                      ")が独立再計算値(" (registry/compute-engagement-fee e) ")と一致しない")}]))))

(defn- already-drafted-violations
  "For `:filing/draft`, refuses to draft the SAME engagement twice."
  [{:keys [op subject]} st]
  (when (= op :filing/draft)
    (when (store/engagement-already-drafted? st subject)
      [{:rule :already-drafted
        :detail (str subject " は既にドラフト済み")}])))

(defn- already-submitted-violations
  "For `:filing/submit`, refuses to submit the SAME engagement twice."
  [{:keys [op subject]} st]
  (when (= op :filing/submit)
    (when (store/engagement-already-submitted? st subject)
      [{:rule :already-submitted
        :detail (str subject " は既に提出済み")}])))

(defn check
  "Censors a MarketEntry-LLM proposal against the governor rules.
  Returns {:ok? bool :violations [..] :confidence c :escalate? bool
  :high-stakes? bool :hard? bool}."
  [request _context proposal st]
  (let [hard (into []
                   (concat (spec-basis-violations request proposal)
                           (evidence-incomplete-violations request st)
                           (foreign-investment-approval-missing-violations request st)
                           (engagement-fee-mismatch-violations request st)
                           (already-drafted-violations request st)
                           (already-submitted-violations request st)))
        conf (:confidence proposal 0.0)
        low? (< conf confidence-floor)
        stakes? (boolean (high-stakes (:stake proposal)))
        hard? (boolean (seq hard))]
    {:ok?          (and (not hard?) (not low?) (not stakes?))
     :violations   hard
     :confidence   conf
     :hard?        hard?
     :escalate?    (and (not hard?) (or low? stakes?))
     :high-stakes? stakes?}))

(defn hold-fact
  "The audit fact written when a proposal is rejected (HOLD)."
  [request context verdict]
  {:t          :governor-hold
   :op         (:op request)
   :actor      (:actor-id context)
   :subject    (:subject request)
   :disposition :hold
   :basis      (mapv :rule (:violations verdict))
   :violations (:violations verdict)
   :confidence (:confidence verdict)})
