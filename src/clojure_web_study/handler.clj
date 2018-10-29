(ns clojure-web-study.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :as json]
            [clojure-web-study.database :as db]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/json" [] {:status 200 :headers {"Content-Type" "application/json"} :body "{name: \"zheng\", age: 26}"})
  (GET "/db" [] (str (nth (db/get-all-knowledge) 0)))
  (GET "/db-json" [] {:status 200 :headers {"Content-Type" "application/json"} :body (nth (db/get-all-knowledge) 0)})
  (GET "/cors" [] {:status 200
                   :headers {"Access-Control-Allow-Origin" "http://localhost:8081"
                             "Access-Control-Allow-Methods" "POST, GET"
                             "Access-Control-Allow-Credentials" "true"
                             "Access-Control-Allow-Headers" "X-PINGOTHER, Content-Type"
                             "Access-Control-Max-Age" "86400"}
                   :body "Hello world"})
  (route/not-found "Not Found"))

(def app1
  (wrap-defaults app-routes site-defaults))

(def app
  (-> app-routes
      json/wrap-json-response
      json/wrap-json-body))
