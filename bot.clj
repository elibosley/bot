(require '[clojure.string :as string])

(defn get-arena-dimensions
  "returns the dimensions of a given arena (NOTE: Not 0 based)"
  [arena]
  (let [x ((comp count first) arena)
        y (count arena)]
    [x y]))

(defn pprint-arena
  "Pretty Print for a given arena"
  [arena]
  (let [[x-len _] (get-arena-dimensions arena)
        x-indices (range x-len)]
    (println " " (string/join " " (map #(format "%2d" %) x-indices)))
    (print
     (string/join "\n" (map-indexed (fn [idx row]
                                      (print
                                       (format "%2d" idx)
                                       (string/join "  " (map :display row))
                                       "\n")) arena)))))

(defn run
  [{:keys  [arena state bot_id energy spawn-bot?] :as step-details}]
  (let [command-options [[{:cmd  "SHOOT"
                           :metadata  {:direction (rand-nth  [0 1 2 3 4 5 6 7]) :energy 20}}
                          {:cmd  "SET_STATE"
                           :metadata  {:foo  "bar"}}]
                         [{:cmd  "MOVE"
                           :metadata  {:direction (rand-nth  [0 1 2 3 4 5 6 7])}}]]]
    {:commands (rand-nth command-options)}))
