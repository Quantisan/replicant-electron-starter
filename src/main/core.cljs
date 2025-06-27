(ns main.core
  (:require ["electron/main" :refer [app BrowserWindow]]
            ["path" :as path]
            ["electron-reload" :as electron-reload]))

(electron-reload (.cwd js/process) #js {:ignored #"node_modules|[/\\]\.|target"})


(defn create-window []
  (let [win (BrowserWindow.
              (clj->js {:width 800
                        :height 600
                        :webPreferences {:preload (.join path js/__dirname "../resources/public/js/preload.js")}}))]
    (.loadFile win "resources/public/index.html")))

(defn main []
  (-> (.whenReady app)
      (.then (fn []
               (create-window)
               (.on app "activate"
                    #(when (zero? (.-length (.getAllWindows BrowserWindow)))
                       (create-window))))))

  (.on app "window-all-closed"
       #(when-not (= (.-platform js/process) "darwin")
          (.quit app))))
