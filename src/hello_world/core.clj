(ns hello-world.core)

(defn -main [& args]
  (println "Hello, World!"))

(defn rotate-element
  ([unrotated remaining-rotations-count]
   (rotate-element unrotated (vector) remaining-rotations-count)
   )
  ([unrotated rotating remaining-rotations-count]
  (if (= remaining-rotations-count 0)
    (concat unrotated rotating)
    (let [front (first unrotated)
          remaining (rest unrotated)
          building (conj rotating front)
          updated-remaining-rotations (- remaining-rotations-count 1)]
      (rotate-element remaining building updated-remaining-rotations))))
  )

(defn rotate-element-slow [elements remaining-rotations-count]
  (if (= remaining-rotations-count 0)
    elements
    (let [front (first elements)
          remaining (rest elements)
          as-v (reverse (into [] remaining))
          rotated (conj as-v front)
          as-l (into () rotated)
          updated-remaining-rotations (- remaining-rotations-count 1)]
      (rotate-element-slow as-l updated-remaining-rotations))))

(defn rotLeft [a d]
  (rotate-element a d))
