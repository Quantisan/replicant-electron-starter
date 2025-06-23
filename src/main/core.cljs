(ns main.core
  (:require ["electron/main" :refer [app BrowserWindow]]))

(def main-window (atom nil))

(defn create-window []
  (reset! main-window (BrowserWindow.
                        (clj->js {:width 800
                                  :height 600})))
  (.loadFile @main-window "resources/public/index.html"))

(defn main []
  (.then (.whenReady app)
         (fn []
           (create-window)
           (.on app "activate" 
                (fn []
                  (when (= (.-length (.getAllWindows BrowserWindow)) 0)
                    (create-window))))))
  
  (.on app "window-all-closed" 
       (fn []
         (when-not (= (.-platform js/process) "darwin")
           (.quit app)))))
