
(ns js-window.location
    (:require [mid-fruits.uri :as uri]))


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
