(ns user
  (:require [mount.core :as mount]
            clicker.core))

(defn start []
  (mount/start-without #'clicker.core/repl-server))

(defn stop []
  (mount/stop-except #'clicker.core/repl-server))

(defn restart []
  (stop)
  (start))


