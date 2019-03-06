(ns clojure-web-study.database
  (:use korma.db
        korma.core))

(defdb korma-db (mysql {:db "test",
                        :host "dev.qjun.com.cn",
                        :port 3306,
                        :user "qjun_dev",
                        :password "6^KwwVPbxz4RTaBebDG&YJ3!USLMiVyU"}))
;(declare courses)
(defentity user)

(defn get-all-knowledge []
  (dry-run
    (select user))
  (select user))

(defn get-by-id [id]
  (dry-run
    (select user
            (where {:id id})))
  (select user
          (where {:id id})))