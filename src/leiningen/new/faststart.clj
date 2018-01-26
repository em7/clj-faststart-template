(ns leiningen.new.faststart
  (:require [leiningen.new.templates :refer [renderer name-to-path
			  ->files multi-segment sanitize-ns]]
            [leiningen.core.main :as main]))

(def render (renderer "faststart"))

(defn faststart
  "Combined Java/Clojure program starting fast from console."
  [name]
  (let [main-ns (multi-segment (sanitize-ns name))
		data {:name name
			  :namespace main-ns
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' faststart project.")
    (->files data
			 ["doc/intro.md" (render "intro.md" data)]
			 ["src/clojure/{{sanitized}}/core.clj" (render "core.clj" data)]
			 ["test/{{sanitized}}/core.clj" (render "core_test.clj" data)]
			 ["src/java/{{sanitized}}/GreetingsFactory.java" (render "GreetingsFactory.java" data)]
			 ["src/java/{{sanitized}}/Main.java" (render "Main.java" data)]
			 [".gitignore" (render ".gitignore" data)]
			 ["project.clj" (render "project.clj" data)]
			 [".hgignore" (render ".hgignore" data)]
			 ["README.md" (render "README.md" data)]
			 ["LICENSE" (render "LICENSE" data)]
			 ["CHANGELOG.md" (render "CHANGELOG.md" data)])))
