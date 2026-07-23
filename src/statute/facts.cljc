(ns statute.facts
  "General-law compliance catalog for Croatia (HRV) -- per ADR-2607141700
  (cloud-itonami-compliance-fact-federation), mirroring the shape of
  cloud-itonami-iso3166-pol/-srb/-svn/-... `statute.facts`. Croatia was
  previously culture-catalog-only in this repo, with no statute.facts --
  this entry closes that structural gap for the HRV entity.

  PROVENANCE DISCLOSURE (read before trusting any citation below):

  All four entries below were corroborated this session directly against
  zakon.hr's consolidated-text ('pročišćeni tekst zakona') citation
  headers, which display the exact Narodne novine (NN, Official Gazette)
  base number and every amending NN number as distinct badges on the
  fetched page. This is a MATERIALLY STRONGER provenance shape than the
  Slovenia sibling's (whose gov.si/spot.gov.si citations did not render
  exact Uradni list RS numbers for two of its three entries) -- every
  HRV entry below carries a complete, session-verified NN citation
  chain, not a disclosed gap.

  Zakon o trgovačkim društvima (Companies Act) --
  https://www.zakon.hr/z/546/zakon-o-trgova%C4%8Dkim-dru%C5%A1tvima,
  fetched this session: consolidated text, base NN 111/93, amended
  through a long chain confirmed present on the page (34/99, 121/99,
  52/00, 118/03, 107/07, 146/08, 137/09, 125/11, 152/11, 111/12, 68/13,
  110/15, 40/19, 34/22, 18/23 -- this is the same law zakon.hr's own
  'Povezani zakoni' sidebar cross-references from the foreign-investment
  law's page, corroborating it independently).

  Zakon o radu (Labour Act) --
  https://www.zakon.hr/z/307/zakon-o-radu, fetched this session:
  consolidated text, base NN 93/14, amended through 127/17, 98/19,
  151/22, 46/23, 64/23 (all NN badges confirmed present on the fetched
  page's citation header).

  Opći porezni zakon (General Tax Act) --
  https://www.zakon.hr/z/100/opci-porezni-zakon, fetched this session:
  consolidated text, base NN 115/16, amended through 106/18, 121/19,
  32/20, 42/20, 114/22, 152/24, 151/25 (the 151/25 amendment is itself
  very recent, late 2025 -- confirmed present on the fetched page's
  citation header).

  Zakon o provjeri stranih ulaganja (Act on the Verification of Foreign
  Investments) -- Croatia's national FDI-screening law implementing EU
  Regulation 2019/452, and the FLAGSHIP spec-basis for
  `marketentry.governor`'s `foreign-investment-approval-missing` check
  (see `marketentry.facts` and `marketentry.governor` for the full
  article-level citation trail). Published Narodne novine 136/2025 (5
  November 2025), in force since 13 November 2025 -- confirmed via
  THREE independently fetched official sources this session: the full
  consolidated text at
  https://www.zakon.hr/z/3974/zakon-o-provjeri-stranih-ulaganja, the
  primary Official Gazette publication itself at
  https://narodne-novine.nn.hr/clanci/sluzbeni/2025_11_136_2010.html,
  and the Ministry of Finance's own explanatory notice at
  https://mfin.gov.hr/vijesti/zakon-o-provjeri-stranih-ulaganja-opce-informacije/4054.
  This is the newest law in this catalog by a wide margin, and (per the
  Ministry of Finance's own notice) its adoption is stated to fulfil one
  of Croatia's OECD-accession criteria -- a genuinely Croatia-specific
  policy driver.

  An entry not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "ISO3166 alpha-3 -> vector of statute entries."
  {"HRV"
   [{:statute/id "hrv.ztd-zakon-o-trgovackim-drustvima"
     :statute/title "Zakon o trgovačkim društvima (Companies Act)"
     :statute/jurisdiction "HRV"
     :statute/kind :law
     :statute/law-number "NN 111/93, 34/99, 121/99, 52/00, 118/03, 107/07, 146/08, 137/09, 125/11, 152/11, 111/12, 68/13, 110/15, 40/19, 34/22, 18/23 (pročišćeni tekst)"
     :statute/url "https://www.zakon.hr/z/546/zakon-o-trgova%C4%8Dkim-dru%C5%A1tvima"
     :statute/url-provenance :zakon-hr-consolidated-text
     :statute/enacted-date "1993-01-01"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "hrv.zor-zakon-o-radu"
     :statute/title "Zakon o radu (Labour Act)"
     :statute/jurisdiction "HRV"
     :statute/kind :law
     :statute/law-number "NN 93/14, 127/17, 98/19, 151/22, 46/23, 64/23 (pročišćeni tekst)"
     :statute/url "https://www.zakon.hr/z/307/zakon-o-radu"
     :statute/url-provenance :zakon-hr-consolidated-text
     :statute/enacted-date "2014-08-07"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor :employment}}
    {:statute/id "hrv.opz-opci-porezni-zakon"
     :statute/title "Opći porezni zakon (General Tax Act)"
     :statute/jurisdiction "HRV"
     :statute/kind :law
     :statute/law-number "NN 115/16, 106/18, 121/19, 32/20, 42/20, 114/22, 152/24, 151/25 (pročišćeni tekst)"
     :statute/url "https://www.zakon.hr/z/100/opci-porezni-zakon"
     :statute/url-provenance :zakon-hr-consolidated-text
     :statute/enacted-date "2016-12-31"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:tax}}
    {:statute/id "hrv.zpsu-zakon-o-provjeri-stranih-ulaganja"
     :statute/title "Zakon o provjeri stranih ulaganja (Act on the Verification of Foreign Investments)"
     :statute/jurisdiction "HRV"
     :statute/kind :law
     :statute/law-number "NN 136/2025"
     :statute/url "https://narodne-novine.nn.hr/clanci/sluzbeni/2025_11_136_2010.html"
     :statute/url-provenance :official-narodne-novine-gazette
     :statute/enacted-date "2025-11-13"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:foreign-investment :national-security}}]})

(defn spec-basis [jurisdiction] (get catalog jurisdiction))

(defn coverage
  ([] (coverage (keys catalog)))
  ([jurisdictions]
   (let [have (filter catalog jurisdictions)
         missing (remove catalog jurisdictions)]
     {:requested (count jurisdictions)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-hrv statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "HRV")) " Croatia entries seeded, "
                 "each independently corroborated via zakon.hr's consolidated-text "
                 "NN citation header and, for the foreign-investment entry, "
                 "cross-confirmed against the primary narodne-novine.nn.hr gazette "
                 "text and mfin.gov.hr's own explanatory notice -- see catalog "
                 "docstring for the full source trail. Extend `statute.facts/catalog`, "
                 "never fabricate an id/url.")})))

(defn by-topic [jurisdiction topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis jurisdiction)))
