(ns site.tools
  (:require [reagent.core :as reagent]
            [secretary.core :as secretary]
            [demo.core :as core]))

(enable-console-print!)

(defn template [{:keys [body]}]
  [:html
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:link {:rel "stylesheet"
            :type "text/css"
            :href "https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.css"}]]
   [:body
    [:div#app [body]]
    [:script {:type "text/javascript" :src "goog/base.js"}]
    [:script {:type "text/javascript" :src "app.js"}]
    [:script {:type "text/javascript"
              :dangerouslySetInnerHTML {:__html "goog.require('demo.client');"}}]
    [:script {:type "text/javascript"
              :dangerouslySetInnerHTML {:__html "goog.require('demo.figwheel');"}}]]])


(defn ^:export render-page [path]
  (reagent/render-to-static-markup (do
                                     (secretary/dispatch! path)
                                     [template {:body core/app-view}])))
