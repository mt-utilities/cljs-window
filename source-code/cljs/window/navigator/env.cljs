
(ns window.navigator.env)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn user-agent
  ; @description
  ; Returns the actual user agent.
  ;
  ; @usage
  ; (user-agent)
  ; =>
  ; "Mozilla/x.x (Macintosh; Intel Mac OS X xx_xx_x) AppleWebKit/xxx.xx (KHTML, like Gecko) Chrome/xxx.x.x.x Safari/xxx.xx"
  ;
  ; @return (string)
  []
  (-> js/window .-navigator .-userAgent))

(defn language
  ; @description
  ; Returns the preferred language of the user, usually the language of the browser UI.
  ;
  ; @usage
  ; (language)
  ; =>
  ; "en-GB"
  ;
  ; @return (string)
  []
  (-> js/window .-navigator .-language))

(defn browser-online?
  ; @description
  ; Returns TRUE if the browser is connected to the internet.
  ;
  ; @usage
  ; (browser-online?)
  ; =>
  ; true
  ;
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine boolean))

(defn browser-offline?
  ; @description
  ; Returns TRUE if the browser is NOT connected to the internet.
  ;
  ; @usage
  ; (browser-offline?)
  ; =>
  ; true
  ;
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine not))

(defn touch-events-api-available?
  ; @description
  ; Returns TRUE if the page can use touch pointer devices.
  ;
  ; @usage
  ; (touch-events-api-available?)
  ; =>
  ; true
  ;
  ; @return (boolean)
  []
  (boolean (or (.hasOwnProperty js/window "ontouchstart")
               (-> js/window .-navigator .-maxTouchPoints   (> 0))
               (-> js/window .-navigator .-msMaxTouchPoints (> 0))
               (and (.-DocumentTouch js/window)
                    (instance? "DocumentTouch" js/document)))))
