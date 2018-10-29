(ns clojure-web-study.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [clojure-web-study.database :as db]))

(defroutes app-routes
           (GET "/" [] "Hello World - 1")
           (GET "/json-1" [] {:status 200 :headers {"Content-Type" "application/json"} :body "{name: \"zheng\", age: 26}"})
           (GET "/json-wrapper" [] (response {:key "hello"}))
           (GET "/db" [] (response (nth (db/get-all-knowledge) 0)))
           (GET "/db/:id" [id] (response (db/get-by-id id)))
           (route/not-found "Not Found"))

(def app
  (json/wrap-json-body
    (json/wrap-json-response
      (wrap-defaults app-routes (assoc-in site-defaults [:responses :content-types] false)))))
