
(ns window.dimensions.helpers)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn viewport-height
  ; @description
  ; Returns the actual viewport height read from the JS Window object.
  ;
  ; @usage
  ; (viewport-height)
  ;
  ; @return (px)
  []
  (.-innerHeight js/window))

(defn viewport-width
  ; @description
  ; Returns the actual viewport width read from the JS Window object.
  ;
  ; @usage
  ; (viewport-width)
  ;
  ; @return (px)
  []
  (.-innerWidth js/window))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn viewport-shape
  ; @description
  ; Returns the actual viewport shape determined by using viewport dimensions
  ; read from the JS Window object.
  ;
  ; @usage
  ; (viewport-shape)
  ;
  ; @return (keyword)
  ; :landscape, :portrait, :square
  []
  (let [viewport-height (.-innerHeight js/window)
        viewport-width  (.-innerWidth  js/window)]
       (cond (< viewport-height viewport-width) :landscape
             (> viewport-height viewport-width) :portrait
             :else :square)))
