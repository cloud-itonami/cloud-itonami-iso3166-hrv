(ns marketentry.facts
  "Croatia (Republic of Croatia, EU member state, eurozone + Schengen
  member) market-entry catalog. Every HRV field is WebFetch/curl-verified
  this tick against the official government sites named in `:provenance`
  -- an entry NOT in `catalog` has no spec-basis, full stop; extend
  `catalog`, never invent an authority/URL.

  Verified this tick:
  - https://eojn.nn.hr/Oglasnik/ -- 'Elektronički oglasnik javne nabave
    Republike Hrvatske' (EOJN RH, Electronic Public Procurement Notices
    Gazette of the Republic of Croatia) confirmed live via its own
    cookie-consent banner text: 'Elektronički oglasnik javne nabave
    Republike Hrvatske koristi \"kolačiće\" (\"cookies\").'. EOJN RH is
    operated on the nn.hr domain (Narodne novine, the official gazette
    publisher).
  - https://gov.hr/?id=2457 -- gov.hr's own 'Javna nabava' (Public
    Procurement) topic page states verbatim: 'Javna nabava provodi se
    kroz Elektronički oglasnik javne nabave Republike Hrvatske (EOJN
    RH)' (Public procurement is conducted through EOJN RH) and 'EOJN RH
    potencijalnim ponuditeljima omogućuje registraciju, uvid u
    dokumentacije o nabavi, ... slanje ponude, Standardni obrazac
    europske jedinstvene dokumentacije o nabavi (ESPD-obrazac) ...' (EOJN
    RH lets prospective bidders register, view/download procurement
    documentation, submit a tender, and the ESPD -- European Single
    Procurement Document -- form). Also states the open-procedure
    eligibility rule verbatim: 'Ponuditelji u otvorenom postupku mogu
    biti svi zainteresirani gospodarski subjekti. Temelje javne nabave
    čine načela unutarnjeg tržišta Europske unije kojima se uređuju
    sloboda kretanja robe, sloboda poslovnog nastana i sloboda pružanja
    usluga.' (Bidders in an open procedure may be any interested economic
    operator; public procurement rests on EU internal-market principles
    of free movement of goods, freedom of establishment and freedom to
    provide services.)
  - https://mingo.gov.hr/ -- Ministarstvo gospodarstva (Ministry of the
    Economy) homepage, fetched live, lists 'Sustav javne nabave' (the
    public procurement system) among its own topic links -- corroborating
    the ministry's policy role alongside EOJN RH/Narodne novine's
    operational role.
  - https://www.zakon.hr/z/223/zakon-o-javnoj-nabavi -- 'Zakon o javnoj
    nabavi' (Public Procurement Act), consolidated text, base NN 120/16,
    amended NN 114/22 and NN 48/26 (all three NN badges confirmed present
    on the fetched page's citation header this session).
  - https://www.dkom.hr/ -- 'Državna komisija za kontrolu postupaka
    javne nabave' (DKOM, State Commission for the Supervision of Public
    Procurement Procedures) -- Croatia's procurement-award legality
    review body, confirmed live (page title fetched verbatim).
  - https://sudreg.pravosudje.hr/registar/f?p=150:1 -- 'Sudski registar
    - Pretraga subjekata' (Court Registry -- Subject Search), Croatia's
    official commercial/company register, run under the Ministry of
    Justice's pravosudje.hr domain via the commercial courts (Trgovački
    sudovi -- the page lists all 11 by name: Bjelovar, Dubrovnik, Osijek
    [+ Slavonski Brod branch], Pazin, Rijeka, Split, Varaždin, Zadar [+
    Šibenik branch], Zagreb [+ Karlovac branch]). Search fields include
    MBS (matični broj subjekta, the registry number) and OIB.
  - https://www.zakon.hr/z/271/zakon-o-sudskom-registru -- 'Zakon o
    sudskom registru' (Court Registry Act), consolidated text, base NN
    1/95, amended through NN 123/23 (full amendment chain -- 57/96,
    1/98, 30/99, 45/99, 54/05, 40/07, 91/10, 90/11, 148/13, 93/14,
    110/15, 40/19, 34/22, 123/23 -- confirmed present on the fetched
    page's citation header this session).
  - https://porezna-uprava.gov.hr/hr/osobni-identifikacijski-broj/7853
    and https://www.zakon.hr/z/83/zakon-o-osobnom-identifikacijskom-broju
    -- OIB (osobni identifikacijski broj, personal identification
    number) is Croatia's unique tax/registry identifier. 'Zakon o
    osobnom identifikacijskom broju' (base NN 60/08, amended through NN
    123/23) Art. 3 (fetched this session) states verbatim that OIB
    obligors include 'hrvatski državljani, pravne osobe sa sjedištem na
    području Republike Hrvatske i strane fizičke i pravne osobe kod
    kojih je nastao povod za praćenje na području Republike Hrvatske' --
    i.e. foreign natural/legal persons for whom a cause for tracking
    arose on Croatian territory are OIB obligors alongside domestic
    entities, and the assigning authority is confirmed as Ministarstvo
    financija (Ministry of Finance, via Porezna uprava / the Tax
    Administration) at Art. 4 para (5) of the same fetched text.
  - FLAGSHIP spec-basis (feeds `foreign-investment-approval-spec-basis`
    below and `marketentry.governor`'s
    `foreign-investment-approval-missing`): Croatia adopted its OWN
    national foreign-direct-investment screening law, 'Zakon o provjeri
    stranih ulaganja' (Act on the Verification of Foreign Investments),
    published in Narodne novine 136/2025 (5 November 2025) and IN FORCE
    since 13 November 2025 -- confirmed via THREE independently fetched
    official sources this session: (1) the full consolidated text at
    https://www.zakon.hr/z/3974/zakon-o-provjeri-stranih-ulaganja, (2)
    the primary Official Gazette publication itself at
    https://narodne-novine.nn.hr/clanci/sluzbeni/2025_11_136_2010.html
    (Hrvatski sabor session 24 October 2025, promulgated by President
    Zoran Milanović 30 October 2025), and (3) the Ministry of Finance's
    own explanatory notice at
    https://mfin.gov.hr/vijesti/zakon-o-provjeri-stranih-ulaganja-opce-informacije/4054
    (published 18 December 2025), which states verbatim: 'Dana 13.
    studenoga 2025. godine stupio je na snagu Zakona o provjeri stranih
    ulaganja (\"Narodne novine\", broj 136/2025 ...), kojim se osigurava
    provedba Uredbe (EU) 2019/452 ...' and further: 'Donošenjem ovoga
    Zakona ispunjen je jedan od kriterija za pristup Republike Hrvatske
    OECD-u.' (adoption of this Act fulfils one of the criteria for
    Croatia's OECD accession -- a genuinely Croatia-specific policy
    driver distinct from Slovenia's or Serbia's own FDI-regime stories).
    See `marketentry.governor` docstring for the full check reasoning
    and article-level citation trail (Čl. 6(11), 11(1)(a), 11(3),
    12(3)).")

(def catalog
  {"HRV" {:name "Croatia"
          :owner-authority "Elektronički oglasnik javne nabave Republike Hrvatske (EOJN RH) -- operated on the Narodne novine (nn.hr) domain; policy oversight includes Ministarstvo gospodarstva (Ministry of the Economy, whose own site lists 'Sustav javne nabave' among its topics)"
          :legal-basis "Zakon o javnoj nabavi (NN 120/16, 114/22, 48/26)"
          :national-spec "EOJN RH (Elektronički oglasnik javne nabave Republike Hrvatske) -- bidder/economic-operator registration, ESPD form submission"
          :provenance "https://eojn.nn.hr/Oglasnik/"
          :required-evidence ["Sudski registar entry (MBS registration number, legal form, active status)"
                               "OIB (osobni identifikacijski broj) assignment record"
                               "EOJN RH bidder/economic-operator registration record"
                               "ESPD (europska jedinstvena dokumentacija o nabavi) form on file"
                               "Authorized-signatory record"]
          ;; Flagship check basis -- see marketentry.governor
          ;; `foreign-investment-approval-missing-violations`. Grounded
          ;; in Zakon o provjeri stranih ulaganja (NN 136/2025, in force
          ;; 13.11.2025), which implements Regulation (EU) 2019/452 and,
          ;; distinctively for this vertical, Čl. 6(3) + Čl. 11(1)(a) +
          ;; Čl. 12(3) tie the approval obligation PROCEDURALLY to
          ;; sudski registar filing itself (the nadležni trgovački sud
          ;; is a named 'kontrolno tijelo' under the law) -- a realistic
          ;; and directly on-domain overlap for a market-entry actor
          ;; whose own required-evidence checklist already includes a
          ;; Sudski registar entry.
          :foreign-investment-approval-owner-authority "Ministarstvo financija Republike Hrvatske (Ministry of Finance) -- coordinates Povjerenstvo za provjeru stranih ulaganja (Commission for the Verification of Foreign Investments) and the Nacionalna kontaktna točka (National Contact Point); decisions issued as rješenje (administrative decision) by Ministarstvo financija itself, Čl. 12(2) + Čl. 16"
          :foreign-investment-approval-legal-basis "Zakon o provjeri stranih ulaganja (NN 136/2025, na snazi od 13.11.2025), Čl. 6(11) [10% kvalificirani udio threshold], Čl. 6(3) [completion tied to sudski registar upis], Čl. 11(1)(a)+(3) [nadležni trgovački sud as kontrolno tijelo], Čl. 12(1)-(4) [pre-registration approval application]"
          :foreign-investment-approval-provenance "https://mfin.gov.hr/vijesti/zakon-o-provjeri-stranih-ulaganja-opce-informacije/4054"
          ;; Secondary (non-flagship) nonresident evidence -- feeds
          ;; `evidence-incomplete`, not its own governor check, same
          ;; discipline as Slovenia's FURS davčna številka / Serbia's
          ;; PIB (each country's own tax-identifier assignment fact for
          ;; a foreign legal entity).
          :nonresident-oib-owner-authority "Porezna uprava (Tax Administration), under Ministarstvo financija"
          :nonresident-oib-legal-basis "Zakon o osobnom identifikacijskom broju (NN 60/08, ..., 123/23), Čl. 3 [foreign natural/legal persons as OIB obligors] + Čl. 4(5) [assigning authority]"
          :nonresident-oib-provenance "https://porezna-uprava.gov.hr/hr/osobni-identifikacijski-broj/7853"}
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR"
          :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "DEU" {:name "Germany" :owner-authority "e-Vergabe" :legal-basis "GWB/VgV"
          :national-spec "e-Vergabe" :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract" "e-Vergabe registration record" "USt-IdNr record" "Authorized-representative record"]}
   "NLD" {:name "Netherlands" :owner-authority "TenderNed" :legal-basis "Aanbestedingswet"
          :national-spec "TenderNed" :provenance "https://www.tenderned.nl/"
          :required-evidence ["KvK extract" "TenderNed registration" "BTW record" "Authorized-representative record"]}})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))

(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))

(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))

(defn foreign-investment-approval-spec-basis
  "Spec-basis for the flagship `foreign-investment-approval-missing`
  governor check -- Croatia's own national FDI-screening approval
  requirement under the Zakon o provjeri stranih ulaganja (NN 136/2025,
  in force 13.11.2025), which implements EU Regulation 2019/452."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:foreign-investment-approval-owner-authority sb)
      (select-keys sb [:foreign-investment-approval-owner-authority
                        :foreign-investment-approval-legal-basis
                        :foreign-investment-approval-provenance]))))

(defn nonresident-oib-spec-basis
  "Spec-basis for the (non-flagship) Croatian OIB (osobni
  identifikacijski broj) registration requirement for a foreign legal
  entity -- feeds `evidence-incomplete`, not its own dedicated HARD
  governor check."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:nonresident-oib-owner-authority sb)
      (select-keys sb [:nonresident-oib-owner-authority
                        :nonresident-oib-legal-basis
                        :nonresident-oib-provenance]))))
