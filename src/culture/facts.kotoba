(ns culture.facts
  "Country-level regional-culture catalog for Croatia (HRV) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  the `marketentry.facts` / `statute.facts` catalogs of the iso3166
  siblings (ADR-2607141700); city-level counterparts live in the
  cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"HRV"
   [{:culture/id "hrv.dish.zagorski-strukli"
     :culture/name "Zagorski štrukli"
     :culture/country "HRV"
     :culture/kind :dish
     :culture/summary "Traditional Croatian pastry dish of thin dough with fillings such as cottage cheese, eggs and sour cream, boiled or baked, from the Hrvatsko Zagorje and Zagreb regions in the north of the country."
     :culture/url "https://en.wikipedia.org/wiki/Zagorski_%C5%A1trukli"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "hrv.dish.soparnik"
     :culture/name "Soparnik"
     :culture/country "HRV"
     :culture/kind :dish
     :culture/summary "Traditional Croatian savory pie from the Dalmatian region of Poljica, filled with Swiss chard, onion, garlic and olive oil, baked between thin sheets of unleavened dough."
     :culture/url "https://en.wikipedia.org/wiki/Soparnik"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "hrv.dish.pasticada"
     :culture/name "Pašticada"
     :culture/country "HRV"
     :culture/kind :dish
     :culture/summary "Braised beef dish in a sweet and sour sauce, popular in Croatia and originating from Dalmatia, traditionally served at special occasions."
     :culture/url "https://en.wikipedia.org/wiki/Pa%C5%A1ticada"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "hrv.beverage.maraschino"
     :culture/name "Maraschino"
     :culture/country "HRV"
     :culture/kind :beverage
     :culture/summary "Liqueur obtained from the distillation of Marasca cherries; industrial-scale production began in Zadar, Croatia, in 1759."
     :culture/url "https://en.wikipedia.org/wiki/Maraschino"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "hrv.product.pag-cheese"
     :culture/name "Pag cheese"
     :culture/country "HRV"
     :culture/kind :product
     :culture/summary "Hard sheep's-milk cheese from the Croatian Adriatic island of Pag, aged between 2 and 18 months, with protected designation of origin status."
     :culture/url "https://en.wikipedia.org/wiki/Pag_cheese"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "hrv.craft.licitar"
     :culture/name "Licitar"
     :culture/country "HRV"
     :culture/kind :craft
     :culture/summary "Colorfully decorated biscuits of sweet honey dough, part of Croatia's cultural heritage; the gingerbread craft from Northern Croatia was inscribed on UNESCO's intangible cultural heritage list in 2010."
     :culture/url "https://en.wikipedia.org/wiki/Licitar"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "hrv.festival.sinjska-alka"
     :culture/name "Sinjska alka"
     :culture/country "HRV"
     :culture/kind :festival
     :culture/summary "Equestrian tournament held annually in Sinj, Croatia, since 1715, in which horsemen at full gallop aim lances at a hanging metal ring; inscribed as UNESCO intangible cultural heritage in 2010."
     :culture/url "https://en.wikipedia.org/wiki/Sinjska_alka"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "hrv.heritage.diocletians-palace"
     :culture/name "Diocletian's Palace"
     :culture/country "HRV"
     :culture/kind :heritage
     :culture/summary "Ancient Roman palace built by Emperor Diocletian at the end of the 3rd century AD, forming about half of the old town of Split; a UNESCO World Heritage Site inscribed in 1979."
     :culture/url "https://en.wikipedia.org/wiki/Diocletian%27s_Palace"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-hrv culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "HRV"))
                 " HRV entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
