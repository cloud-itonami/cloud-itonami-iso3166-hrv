# cloud-itonami-iso3166-hrv

Open ISO 3166 Blueprint for **HRV**: Republic of Croatia (EU member
state, eurozone + Schengen since 2023).

**`:implemented`** for **HRV**. Flagship
`foreign-investment-approval-missing` (Zakon o provjeri stranih
ulaganja, NN 136/2025, in force since 13 November 2025, implementing
EU Regulation 2019/452).

```
clojure -M:dev:test
```

This repository designs a forkable OSS business for an independent
public-sector market-entry consultant: an already-incorporated operator
(e.g. a `cloud-itonami-cofog-{code}`, `cloud-itonami-isco-{code}`,
`cloud-itonami-unspsc-{segment}` or `cloud-itonami-{ISIC}` blueprint
fork) gets a Compliance Advisor + independent **Market-Entry Compliance
Governor** to navigate public-procurement registration, local business/
tax registration, and EU single-market rules in Croatia, so the
operator can win and service a government contract without hiring a
full in-house compliance department.

## No robotics premise — digital/data service exemption

Market-entry and procurement-compliance navigation is a pure data/software
service with no physical-domain work (portal registration, document
checklists, regulatory-change monitoring) — the same exemption class as
`cloud-itonami-6310` (HR SaaS replacement) and `cloud-itonami-gtin-*`.
`blueprint.edn` sets `:itonami.blueprint/robotics false` and
`:required-technologies` lists only real capabilities (`:identity`,
`:forms`, `:dmn`, `:bpmn`, `:audit-ledger`), no `:robotics`.

## Core Contract

```text
operator intake + prior filing history
        |
        v
Compliance Advisor -> Market-Entry Compliance Governor -> filing draft, or human sign-off
        |
        v
gated portal registration / filing submission + audit ledger
```

No automated proposal can submit a portal registration or filing the
governor refuses, suppress a compliance record, or claim a legal/tax
conclusion the governor has not cleared. `:filing/submit` is never in any
phase's `:auto` set — it always requires human sign-off (mirrors
`cloud-itonami-M6910`'s `filing-submit-never-auto-at-any-phase`
invariant).

## Official surface (web-verified)

- Procurement: EOJN RH (Elektronički oglasnik javne nabave Republike
  Hrvatske, eojn.nn.hr), operated on the Narodne novine domain, is the
  public e-procurement portal (confirmed live via its own cookie-consent
  banner text this session); gov.hr's own "Javna nabava" page confirms
  its role verbatim: "Javna nabava provodi se kroz Elektronički oglasnik
  javne nabave Republike Hrvatske (EOJN RH)" and that it handles bidder
  registration, procurement-document access, tender submission and the
  ESPD form. The Zakon o javnoj nabavi (NN 120/16, 114/22, 48/26) is the
  legal basis. Procurement-award legality is reviewed by the Državna
  komisija za kontrolu postupaka javne nabave (DKOM, dkom.hr, confirmed
  live).
- Business/tax: Sudski registar (Court Registry, sudreg.pravosudje.hr),
  Croatia's official commercial register run via the 11 Trgovački
  sudovi (commercial courts) under the Ministry of Justice, assigns the
  MBS registration number -- legal basis Zakon o sudskom registru (NN
  1/95, ..., 123/23). Porezna uprava (Tax Administration, under
  Ministarstvo financija) assigns the OIB (osobni identifikacijski
  broj), including to foreign legal entities "kod kojih je nastao
  povod za praćenje na području Republike Hrvatske" (for whom a cause
  for tracking arose on Croatian territory) -- Zakon o osobnom
  identifikacijskom broju (NN 60/08, ..., 123/23).
- Foreign investment: Croatia adopted its OWN national FDI-screening
  law, the Zakon o provjeri stranih ulaganja (NN 136/2025), IN FORCE
  ONLY SINCE 13 November 2025, implementing EU Regulation 2019/452 --
  administered by Ministarstvo financija (Ministry of FINANCE), whose
  own notice states its adoption fulfils one of the criteria for
  Croatia's OECD accession. Approval is required BEFORE a foreign
  investor acquiring a "kvalificirani udio" (>= 10% of capital/voting
  rights, Čl. 6(11)) files the resulting change for sudski registar
  registration -- Čl. 6(3), 11(1)(a), 11(3) and 12(3) tie the approval
  obligation procedurally to the SAME registry-filing fact this actor's
  own required-evidence checklist already tracks. This is structurally
  different from both Slovenia (EU member, whose ZSInv is an
  amended-in-place 2013-era law administered by the Ministry of
  Economy) and Serbia (EU-candidate, explicitly no FDI-screening
  regime) -- see `src/marketentry/governor.cljc` docstring for the full
  reasoning.

See `src/marketentry/facts.cljc` and `src/statute/facts.cljc` for the
full citation trail. Every law cited carries a complete Narodne novine
(NN) gazette-number chain, independently confirmed this session against
zakon.hr's own consolidated-text citation headers -- no undisclosed
gazette-number gaps in this catalog.

## What this is NOT

- **Not the government of Croatia.** See
  [`docs/business-model.md`](docs/business-model.md) for the boundary with
  `com-etzhayyim-ooyake` (read-only civic mirror), `matsurigoto` (sovereign
  statecraft), `com-etzhayyim-toritsugi` (individual citizen concierge),
  `legal-entity.etzhayyim.com` (read-only data aggregation), and
  `cloud-itonami-M6910` (company incorporation — a different regulatory
  phase this blueprint assumes is already complete).
- **Not legal or tax advice.** Every regulatory claim must cite the
  official source and route final filings to Croatian-licensed counsel
  or a registered agent where the law requires licensed representation.

## Capability layer

Resolves via [`kotoba-lang/iso3166`](https://github.com/kotoba-lang/iso3166)
(ISO 3166 `HRV`). Required capabilities:

- :identity
- :forms
- :dmn
- :bpmn
- :audit-ledger

See [`docs/business-model.md`](docs/business-model.md) and
[`docs/operator-guide.md`](docs/operator-guide.md).

## License

AGPL-3.0-or-later.

## Culture catalog

This repo carries a **country-level regional-culture catalog**
(ADR-2607171400 addendum 2, `cloud-itonami-municipality-culture-catalog`
Wave 1, in `com-junkawasaki/root`) — national dishes, protected products,
beverages, crafts, festivals and heritage sites for Croatia:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring the `statute.facts` convention of the
  iso3166 siblings).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
