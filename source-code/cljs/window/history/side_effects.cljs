
(ns window.history.side-effects)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn go-back!
  ; @description
  ; Navigates the page back in the route history by using the JS Window object.
  ;
  ; @usage
  ; (go-back!)
  [_]
  (-> js/window .-history .back))
