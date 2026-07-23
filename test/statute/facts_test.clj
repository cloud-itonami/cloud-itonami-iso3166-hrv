(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest hrv-has-spec-basis
  (let [sb (facts/spec-basis "HRV")]
    (is (= 4 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["HRV" "POL" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "POL"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["hrv.zpsu-zakon-o-provjeri-stranih-ulaganja"]
         (mapv :statute/id (facts/by-topic "HRV" :foreign-investment))))
  (is (= ["hrv.zor-zakon-o-radu"]
         (mapv :statute/id (facts/by-topic "HRV" :labor))))
  (is (= ["hrv.opz-opci-porezni-zakon"]
         (mapv :statute/id (facts/by-topic "HRV" :tax))))
  (is (empty? (facts/by-topic "ATL" :labor))))
