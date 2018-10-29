(ns clojure-web-study.database
  (:use korma.db
        korma.core))

(defdb korma-db (mysql {:db "learn_english",
                        :host "",
                        :port 3306,
                        :user "",
                        :password ""}))

(defentity t_knowledge)

(defn get-all-knowledge []
  (dry-run
    (select t_knowledge))
  (select t_knowledge))

(defn get-by-id [id]
  (dry-run
    (select t_knowledge
            (where {:id id})))
  (select t_knowledge
          (where {:id id})))