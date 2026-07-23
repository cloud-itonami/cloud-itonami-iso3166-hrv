# ADR-0001: HRV marketentry `:implemented`

Flagship `foreign-investment-approval-missing` -- Zakon o provjeri
stranih ulaganja (Act on the Verification of Foreign Investments), NN
136/2025, in force since 13 November 2025, implementing Regulation (EU)
2019/452 on screening foreign direct investment. Notification/approval
by Ministarstvo financija (Ministry of Finance) is required when a
foreign investor acquires a "kvalificirani udio" -- at least 10% of the
capital, voting rights, property rights or total/business shares of a
Croatian obligor (Čl. 6(11)) -- BEFORE the resulting change is filed
for registration in the sudski registar (Čl. 12(3)), and the competent
commercial court itself is named a statutory "kontrolno tijelo"
(control body, Čl. 11(1)(a)) that acts ex officio to prevent completion
of an unreported foreign investment (Čl. 11(3)) -- independently
fetched and read against THREE separate official sources this tick:
the full consolidated text at zakon.hr, the primary Narodne novine
gazette publication itself, and Ministarstvo financija's own
explanatory notice (published 18 December 2025).

This is deliberately NOT a copy of any sibling's flagship shape:

- Poland (EU member): flagship pair is `eu-establishment-missing` +
  `nip-unverified`, grounded in EU freedom-of-establishment practice
  and Poland's own NIP/KRS numbers -- no FDI-screening check in that
  blueprint.
- Serbia (EU-candidate, non-member): flagship is `nonresident-pib-missing`,
  grounded in Art. 26 Zakon o poreskom postupku i poreskoj
  administraciji; Serbia's own README explicitly discloses NO
  FDI-screening regime (Zakon o ulaganjima gives foreign investors
  national treatment with no notification threshold) -- a genuine
  asymmetry with the EU-member siblings, not an omission.
- Slovenia (EU member, eurozone): flagship is `fdi-notification-missing`,
  grounded in the Zakon o spodbujanju investicij (ZSInv), a law
  amended-in-place since 2013, administered by Ministrstvo za
  gospodarstvo, delo in šport (Ministry of ECONOMY, Labour and Sport),
  and framed around "commencing business activity" generally.

Croatia's own distinguishing structural facts, independently verified
this session, are NOT the same as Slovenia's despite both being EU
FDI-screening regimes:

1. Croatia's Zakon o provjeri stranih ulaganja is a BRAND-NEW,
   standalone statute (NN 136/2025, in force only since 13 November
   2025) -- not an amended-in-place older law. Ministarstvo financija's
   own notice states its adoption "ispunjen je jedan od kriterija za
   pristup Republike Hrvatske OECD-u" (fulfils one of the criteria for
   Croatia's OECD accession) -- a policy driver with no analogue in
   Slovenia's or Serbia's story.
2. It is administered by Ministarstvo financija (Ministry of FINANCE),
   not Ministarstvo gospodarstva (Ministry of Economy) as in Slovenia
   -- a genuinely different institutional home.
3. Unlike Slovenia's ZSInv (framed around "commencing business
   activity" generally), Croatia's ZPSU is procedurally interlocked
   with the EXACT SAME sudski-registar-filing fact this actor's own
   marketentry required-evidence checklist already tracks: Čl. 6(3)
   defines a "completed" foreign investment as one for which the
   nadležni trgovački sud has carried out the sudski registar entry;
   Čl. 11(1)(a) names that same court a statutory control body; Čl.
   12(3) requires the approval application at the latest BEFORE the
   registry filing itself. This is a distinct, on-domain, article-level
   hook -- not a generic "before commencing business" framing borrowed
   from a sibling.

Adding a fabricated eu-establishment/NIP-style pair, or a copy-pasted
PIB/ZSInv-shaped check without this law's OWN article-level hook, would
have been dishonest; a smaller, single, genuinely grounded check is
preferred. See `src/marketentry/governor.cljc` docstring for the full
reasoning and citation trail, and `src/marketentry/facts.cljc` /
`src/statute/facts.cljc` for the complete disclosure of what was
independently confirmed this session -- every citation in this
blueprint carries a complete NN (Narodne novine) gazette number chain
sourced from zakon.hr's own consolidated-text citation headers, a
materially stronger provenance shape than the Slovenia sibling's
(which disclosed several unconfirmed Uradni list RS gazette numbers).
