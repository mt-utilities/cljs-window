
(ns window.navigator)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-user-agent
  ; @return (string)
  []
  (-> js/window .-navigator .-userAgent))

(defn get-language
  ; @return (string)
  []
  (-> js/window .-navigator .-language))

(defn browser-online?
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine boolean))

(defn browser-offline?
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine not))
