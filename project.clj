(defproject clojure-web-study "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [compojure "1.6.1"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-defaults "0.3.2"]
                 [korma "0.4.3"]
                 [org.clojure/java.jdbc "0.3.6"]
                 [mysql/mysql-connector-java "8.0.11"]]
  :plugins [[lein-ring "0.12.4"]]
  :ring {:handler clojure-web-study.core/app
         :auto-reload? true
         :auto-refresh? true}
  :profiles
  {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]
                        [ring/ring-mock "0.3.2"]]}})
