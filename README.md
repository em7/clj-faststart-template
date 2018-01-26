[![Clojars Project](https://img.shields.io/clojars/v/faststart/lein-template.svg)](https://clojars.org/faststart/lein-template)

# faststart

Leiningen template for fast starting Clojure/Java application.

I created this template because sometimes I want to code a command-line app in Clojure. However I don't want users to wait 2s just for `app -h`. In this template, Clojure is used via its `clojure.java.api.Clojure` API and not AOTed. Another advantage is that you can simply put other version of Clojure on classpath without recompile. On the other hand your Clojure application is being compiled when you first call Clojure code. Therefore this application starts slower than AOTed one. The whole reasoning about this setup is *response time*. User can run your application and have response almost immediately without waiting for Clojure to load and initialize.

Is it worth parsing command line arguments, doing some work and calling the application code via clojure.java.api? In most cases not.

## Usage

Install [Leiningen](https://leiningen.org/) if you haven't and put it on your PATH.

`lein new faststart your-app-name`


## License

Copyright © 2018 em7

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
