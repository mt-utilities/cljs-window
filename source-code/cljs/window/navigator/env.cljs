
(ns window.navigator.env)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn user-agent
  ; @description
  ; Returns the actual user agent read from the JS Window object.
  ;
  ; @usage
  ; (user-agent)
  ;
  ; @return (string)
  []
  (-> js/window .-navigator .-userAgent))

(defn language
  ; @description
  ; Returns the preferred language of the user, usually the language of the
  ; browser UI read from the JS Window object.
  ;
  ; @usage
  ; (language)
  ;
  ; @return (string)
  []
  (-> js/window .-navigator .-language))

(defn browser-online?
  ; @description
  ; Returns true if the browser is connected to the internet read from the JS Window object.
  ;
  ; @usage
  ; (browser-online?)
  ;
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine boolean))

(defn browser-offline?
  ; @description
  ; Returns true if the browser is NOT connected to the internet read from the JS Window object.
  ;
  ; @usage
  ; (browser-offline?)
  ;
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine not))

(defn touch-events-api-detected?
  ; @description
  ; Returns true if the page is using touch pointer device determined by using
  ; the JS Window object.
  ;
  ; @usage
  ; (touch-events-api-detected?)
  ;
  ; @return (boolean)
  []
  (boolean (or (.hasOwnProperty js/window "ontouchstart")
               (-> js/window .-navigator .-maxTouchPoints   (> 0))
               (-> js/window .-navigator .-msMaxTouchPoints (> 0))
               (and (.-DocumentTouch js/window)
                    (instance? "DocumentTouch" js/document)))))