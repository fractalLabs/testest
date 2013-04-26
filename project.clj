(defproject testest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [ring "1.1.7"]
                 [ring-json-params "0.1.3"]
                 [hiccup "1.0.2"]
                 [clj-json "0.5.3"]]
  :plugins [[lein-ring "0.8.3"]]
  :ring {:handler testest.core/app})
