(defproject isomorphic "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [reagent "0.6.0-alpha"]
                 [secretary "1.2.3"]
                 [kibu/pushy "0.3.1"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-4"]]

  :clean-targets ^{:protect false} ["output"]

  :cljsbuild {
              :builds [{:id "server"
                        :figwheel true
                        :source-paths ["src" "src-server"]
                        :compiler {
                                   :main demo.server
                                   :output-to "generated/public/js/server-side/server.js"
                                   :output-dir "generated/public/js/server-side"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true 
                                   }}
                       {:id "app"
                        :figwheel true
                        :source-paths ["src" "src-client"]
                        :compiler {
                                   :output-to "generated/public/js/app.js"
                                   :output-dir "generated/public/js"
                                   :optimizations :none
                                   :source-map true
                                   }}]
              }
  )
