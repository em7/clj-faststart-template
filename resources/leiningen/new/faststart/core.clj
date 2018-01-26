(ns {{namespace}}.core
  (:import [{{namespace}} GreetingsFactory]))

(defn hello []
  (print "Hello from Clojure \n")
  (flush)
  "Said Hello from Clojure")

(defn create-greetings-factory []
  (reify GreetingsFactory
    (createGreetingsFor [_ name]
      (str "Hello, " name "!"))))
