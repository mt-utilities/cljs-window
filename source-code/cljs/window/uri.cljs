
(ns window.uri
    (:require [mid-fruits.uri :as uri]))

; A window.uri névtér eredetileg window.location névtér lett volna
;
; Error: Namespace "window.location" already declared.
; at Object.goog.provide
; at ...

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-uri
  ; @return (string)
  []
  (-> js/window .-location .-href))

(defn get-protocol
  ; @return (string)
  []
  (-> js/window .-location .-protocol))

(defn get-hostname
  ; @return (string)
  []
  (-> js/window .-location .-hostname))

(defn get-uri-base
  ; @example
  ;  (get-uri-base)
  ;  =>
  ;  "https://my-domain.com"
  ;
  ; @return (string)
  []
  (let [protocol (get-protocol)
        hostname (get-hostname)]
       (str protocol "//" hostname)))
