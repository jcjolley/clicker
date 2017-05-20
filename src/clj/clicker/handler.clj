(ns clicker.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [clicker.layout :refer [error-page]]
            [clicker.routes.home :refer [home-routes]]
            [clicker.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [clicker.env :refer [defaults]]
            [mount.core :as mount]
            [clicker.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    #'service-routes
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
