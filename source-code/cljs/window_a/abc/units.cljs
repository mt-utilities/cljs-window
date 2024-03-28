
(ns window-a.abc.units
    (:require [fruits.math.api :as math]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn px->vh
  ; @description
  ; Converts the given pixel value into actual VH value calculated by using the viewport height.
  ;
  ; @param (px) n
  ;
  ; @usage
  ; (px->vh 420)
  ; =>
  ; 100
  ;
  ; @return (vh)
  [n]
  (-> n (/ (-> js/window .-innerHeight (/ 100))) math/floor))

(defn px->vw
  ; @description
  ; Converts the given pixel value into actual VW value calculated by using the viewport width.
  ;
  ; @param (px) n
  ;
  ; @usage
  ; (px->vw 420)
  ; =>
  ; 100
  ;
  ; @return (vw)
  [n]
  (-> n (/ (-> js/window .-innerWidth (/ 100))) math/floor))

(defn vh->px
  ; @description
  ; Converts the given VH value into actual pixel value calculated by using the viewport height.
  ;
  ; @param (vh) n
  ;
  ; @usage
  ; (vh->px 100)
  ; =>
  ; 420
  ;
  ; @return (px)
  [n]
  (-> n (* (-> js/window .-innerHeight (/ 100))) math/floor))

(defn vw->px
  ; @description
  ; Converts the given VH value into actual pixel value calculated by using the viewport width.
  ;
  ; @param (vw) n
  ;
  ; @usage
  ; (vw->px 100)
  ; =>
  ; 420
  ;
  ; @return (px)
  [n]
  (-> n (* (-> js/window .-innerWidth (/ 100))) math/floor))
