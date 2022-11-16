
(ns js-window.navigator)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-user-agent
  ; @usage
  ; (get-user-agent)
  ;
  ; @return (string)
  []
  (-> js/window .-navigator .-userAgent))

(defn get-language
  ; @usage
  ; (get-language)
  ;
  ; @return (string)
  []
  (-> js/window .-navigator .-language))

(defn browser-online?
  ; @usage
  ; (browser-online?)
  ;
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine boolean))

(defn browser-offline?
  ; @usage
  ; (browser-offline?)
  ;
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine not))
