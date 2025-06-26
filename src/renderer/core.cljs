(ns renderer.core
  (:require [replicant.dom :as r]))

(defn version-info [versions]
  [:div#info
   "This app is using Chrome (v" (:chrome versions) "), "
   "Node.js (v" (:node versions) "), "
   "and Electron (v" (:electron versions) ")"])

(defn start! []
  ;; In the renderer context, the exposed API should be directly on window
  (let [versions-api (.-versions js/window)
        versions {:chrome ((.-chrome versions-api))
                  :node ((.-node versions-api))
                  :electron ((.-electron versions-api))}]
    (r/render (js/document.getElementById "info")
              (version-info versions))))

