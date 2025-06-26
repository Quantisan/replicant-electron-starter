(ns renderer.core
  (:require [replicant.dom :as r]))

(defn version-info [versions]
  [:div#info
   "This app is using Chrome (v" (:chrome versions) "), "
   "Node.js (v" (:node versions) "), "
   "and Electron (v" (:electron versions) ")"])

(defn get-versions []
  (when-let [versions-api (.-versions js/window)]
    {:chrome   ((.chrome versions-api))
     :node     ((.node versions-api))
     :electron ((.electron versions-api))}))

(defn start! []
  (when-let [versions (get-versions)]
    (r/render (js/document.getElementById "info")
              (version-info versions))))
