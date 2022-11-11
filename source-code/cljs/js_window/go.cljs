
(ns js-window.go)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn go-root!
  ; @usage
  ;  (go-root!)
  [_]
  (set! (-> js/window .-location .-href) "/"))

(defn go-back!
  ; @usage
  ;  (go-back!)
  [_]
  (-> js/window .-history .back))

(defn go-to!
  ; @param (string) uri
  ;
  ; @usage
  ;  (go-to! "www.my-site.com/my-link")
  [uri]
  (set! (-> js/window .-location .-href) uri))
