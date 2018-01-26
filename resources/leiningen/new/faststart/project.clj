(defproject {{namespace}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]]

  :main ^:skip-aot {{namespace}}.Main
  
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  
  :pom-addition [:properties
                 [:maven.compiler.source "1.8"]
                 [:maven.compiler.target "1.8"]]
  
  :javac-options ["-target" "1.8" "-source" "1.8"]
  
  )
