(ns demo.core
  (:require [reagent.core :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]))

(def current-page (atom nil))

(defn navigation []
  [:div.ui.inverted.top.fixed.menu
   [:a.item {:href "/"} "Home Page"]
   [:a.item {:href "/page-one"} "Page One"]
   [:a.item {:href "/page-two"} "Page Two"]
   [:a.item {:href "/page-three"} "Page Three"]])

(defn home-page []
  [:div [navigation] [:h1 "Home Page"]])

(defn page-one []
  [:div [navigation] [:h1 "Page 1"]])

(defn page-two []
  [:div [navigation] [:h1 "Page 2"]])

(defn app-view []
  [:div [@current-page]])

(secretary/set-config! :prefix "/")

(defroute "/" []
  (.log js/console "home page")
  (reset! current-page home-page))

(defroute "/page-one" []
  (.log js/console "page-one")
  (reset! current-page page-one))

(defroute "/page-two" []
  (.log js/console "page-one")
  (reset! current-page page-two))

(reset! current-page home-page)

