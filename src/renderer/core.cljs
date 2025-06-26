(ns renderer.core
  (:require [replicant.dom :as r]))

(defn version-info [versions]
  [:div#info
   "This app is using Chrome (v" (:chrome versions) "), "
   "Node.js (v" (:node versions) "), "
   "and Electron (v" (:electron versions) ")"])

(defn start! []
  (let [versions {:chrome (js/versions.chrome)
                  :node (js/versions.node)
                  :electron (js/versions.electron)}]
    (r/render (js/document.getElementById "info")
              (version-info versions))))
