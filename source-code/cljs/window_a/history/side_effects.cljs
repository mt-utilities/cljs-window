
(ns window-a.history.side-effects)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn go-back!
  ; @description
  ; Navigates back the page in the route history.
  ;
  ; @usage
  ; (go-back!)
  [_]
  (-> js/window .-history .back))
