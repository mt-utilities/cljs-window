
(ns window.dimensions.units
    (:require [fruits.math.api :as math]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn px->vh
  ; @description
  ; Translate the given pixel value into actual VH value by using the viewport
  ; height read from the JS Window object.
  ;
  ; @param (px) n
  ;
  ; @usage
  ; (px->vh 420)
  ;
  ; @return (vh)
  [n]
  (-> n (/ (-> js/window .-innerHeight (/ 100))) math/floor))

(defn px->vw
  ; @description
  ; Translate the given pixel value into actual VW value by using the viewport
  ; width read from the JS Window object.
  ;
  ; @param (px) n
  ;
  ; @usage
  ; (px->vw 420)
  ;
  ; @return (vw)
  [n]
  (-> n (/ (-> js/window .-innerWidth (/ 100))) math/floor))

(defn vh->px
  ; @description
  ; Translate the given VH value into actual pixel value by using the viewport
  ; height read from the JS Window object.
  ;
  ; @param (vh) n
  ;
  ; @usage
  ; (vh->px 42)
  ;
  ; @return (px)
  [n]
  (-> n (* (-> js/window .-innerHeight (/ 100))) math/floor))

(defn vw->px
  ; @description
  ; Translate the given VH value into actual pixel value by using the viewport
  ; width read from the JS Window object.
  ;
  ; @param (vw) n
  ;
  ; @usage
  ; (vw->px 42)
  ;
  ; @return (px)
  [n]
  (-> n (* (-> js/window .-innerWidth (/ 100))) math/floor))
