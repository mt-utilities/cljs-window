
(ns window.dimensions.env)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn viewport-height
  ; @description
  ; Returns the actual viewport height.
  ;
  ; @usage
  ; (viewport-height)
  ; =>
  ; 420
  ;
  ; @return (px)
  []
  (.-innerHeight js/window))

(defn viewport-width
  ; @description
  ; Returns the actual viewport width.
  ;
  ; @usage
  ; (viewport-width)
  ; =>
  ; 420
  ;
  ; @return (px)
  []
  (.-innerWidth js/window))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn viewport-shape
  ; @description
  ; Returns the actual viewport shape, determined by using viewport dimensions.
  ;
  ; @usage
  ; (viewport-shape)
  ; =>
  ; :landscape
  ;
  ; @return (keyword)
  ; :landscape, :portrait, :square
  []
  (let [viewport-height (.-innerHeight js/window)
        viewport-width  (.-innerWidth  js/window)]
       (cond (< viewport-height viewport-width) :landscape
             (> viewport-height viewport-width) :portrait
             :else                              :square)))
