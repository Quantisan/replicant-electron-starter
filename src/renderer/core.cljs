(ns renderer.core
  (:require [replicant.dom :as r]))

(defn version-info [versions]
  [:div#info
   "This app is using Chrome (v" (:chrome versions) "), "
   "Node.js (v" (:node versions) "), "
   "and Electron (v" (:electron versions) ")"])

(defn start! []
  (println "Starting renderer...")
  (println "js/versions:" js/versions)
  (println "js/versions type:" (type js/versions))
  (when js/versions
    (println "js/versions.chrome:" js/versions.chrome)
    (println "js/versions.node:" js/versions.node)
    (println "js/versions.electron:" js/versions.electron))
  (let [versions {:chrome (js/versions.chrome)
                  :node (js/versions.node)
                  :electron (js/versions.electron)}]
    (println "versions map:" versions)
    (r/render (js/document.getElementById "info")
              (version-info versions))))
