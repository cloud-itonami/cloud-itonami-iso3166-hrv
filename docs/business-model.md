# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — Croatia

## Classification

- Repository: `cloud-itonami-iso3166-hrv`
- ISO 3166: `HRV` (Croatia)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Social impact: [:eu-single-market-access :public-spend-transparency :cross-border-friction-reduction]

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on a Croatian
  public contract
- a foreign SME or civic-tech vendor entering the public sector in
  Croatia for the first time
- a `cloud-itonami-M6910` client that has just completed incorporation and
  now needs public-sector market access

## Offer

- registration walkthrough for EOJN (Elektronički oglasnik javne
  nabave / Electronic Public Procurement Journal, eojn.nn.hr), Croatia's
  mandatory publication channel for public-procurement notices above
  statutory thresholds, operated by Narodne novine on behalf of the
  Ministry of Economy
- business/tax registration checklist: an entry in the Sudski registar
  (Court Registry), Croatia's official commercial register maintained by
  commercial courts, searchable via the e-Sudski registar portal (MBS
  registration number, legal form, status)
- local-content / preferential-procurement navigation: EU-wide open
  tendering above EU thresholds (no national-content quota as an EU
  member state), but Croatian-language submission is typically required
- foreign-direct-investment screening navigation: Croatia, as an EU
  member state, adopted its OWN national FDI-screening mechanism
  implementing Regulation (EU) 2019/452 via the Zakon o provjeri
  stranih ulaganja (NN 136/2025), in force only since 13 November 2025.
  Where the operator's own Croatian market presence was established by
  a foreign investor acquiring a "kvalificirani udio" (>= 10% of the
  capital, voting rights, property rights, or total/business shares of
  an existing Croatian company, Čl. 6(11)), this service tracks whether
  the required approval application was filed with Ministarstvo
  financija (Ministry of Finance) BEFORE the resulting change was filed
  for Sudski registar registration -- Čl. 6(3), 11(1)(a), 11(3) and
  12(3) tie the approval obligation procedurally to that same
  registry-filing moment
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual portal registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off (`:filing/submit` is never automated at any phase)
- a false or fabricated regulatory-requirement claim is a HARD hold that
  cannot be overridden by human approval alone — it must be corrected
  against a cited official source first
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to Croatian-licensed counsel or a registered agent
- every requirement cites the official portal or regulation, never
  invented; every citation carries a complete Narodne novine (NN)
  gazette-number chain, independently confirmed this session against
  zakon.hr's own consolidated-text citation headers

## Honest disclosure: Croatia's FDI-screening mechanism is REAL, VERY RECENT, and structurally distinct from both siblings

Unlike Serbia (an EU-candidate, non-member sibling in this fleet, whose
Zakon o ulaganjima gives foreign investors national treatment with no
screening threshold), Croatia's EU membership brings a REAL national
implementation of Regulation (EU) 2019/452's FDI-screening framework --
the Zakon o provjeri stranih ulaganja, NN 136/2025. This is stated here
as a positive, independently verified structural fact about Croatia's
actual regime, not a gap in this catalog's coverage.

It is also NOT a copy of Slovenia's differently-shaped flagship (the
Slovenia sibling's Zakon o spodbujanju investicij is an amended-in-place
2013-era law administered by the Ministry of Economy, Labour and
Sport). Croatia's own law is brand-new (in force only since 13 November
2025), administered by Ministarstvo financija (Ministry of FINANCE),
and its own explanatory notice states its adoption fulfils one of the
criteria for Croatia's OECD accession -- a policy driver with no
analogue in either sibling's story. Most distinctively, Croatia's law
procedurally interlocks the FDI-approval obligation with the SAME
Sudski registar filing fact this actor's own required-evidence
checklist already tracks (Čl. 6(3), 11(1)(a), 11(3), 12(3)) -- a
genuinely on-domain hook, not a generic "before commencing business"
framing borrowed from a sibling's shape. See
`src/marketentry/governor.cljc` for the full reasoning.

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law). This blueprint assumes incorporation is already done and
  handles public-procurement market entry (a different regulatory domain).
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in Croatia).
