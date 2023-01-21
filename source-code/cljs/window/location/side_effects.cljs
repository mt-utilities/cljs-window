
(ns window.location.side-effects)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn go-root!
  ; @description
  ; Navigates the page to the root path ("/") by using the JS Window object.
  ;
  ; @usage
  ; (go-root!)
  [_]
  (set! (-> js/window .-location .-href) "/"))

(defn go-to!
  ; @description
  ; Navigates the page to the given path or URI by using the JS Window object.
  ;
  ; @param (string) uri
  ;
  ; @usage
  ; (go-to! "my-link")
  ;
  ; @usage
  ; (go-to! "www.my-site.com/my-link")
  [uri]
  (set! (-> js/window .-location .-href) uri))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn open-tab!
  ; @description
  ; Opens a new browser tab by using the JS Window object.
  ;
  ; @param (string) uri
  ;
  ; @usage
  ; (open-tab! "www.my-site.com/my-link")
  [uri]
  (.open js/window uri "_blank"))

(defn reload-tab!
  ; @description
  ; Reloads the browser tab by using the JS Window object.
  ;
  ; @usage
  ; (reload-tab!)
  []
  (.reload js/window.location true))
