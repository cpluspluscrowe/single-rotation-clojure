(ns hello-world.core)

(defn -main [& args]
  (println "Hello, World!"))

(defn rotate-element [elements remaining-rotations-count]
  (if (= remaining-rotations-count 0)
    elements
    (let [front (first elements)
          remaining (rest elements)
          as-v (reverse (into [] remaining))
          rotated (conj as-v front)
          as-l (into () rotated)
          updated-remaining-rotations (- remaining-rotations-count 1)]
      (rotate-element as-l updated-remaining-rotations))))

(defn rotLeft [a d]
  (rotate-element a d))
