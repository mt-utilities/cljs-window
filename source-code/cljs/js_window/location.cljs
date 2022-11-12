
(ns js-window.location
    (:require [mid-fruits.string :as string]))

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

(defn get-uri-path
  ; @example
  ;  (get-uri-path)
  ;  =>
  ;  "/my-path"
  ;
  ; @return (string)
  []
  (let [hostname (get-hostname)]
       (-> (get-uri)
           (string/after-first-occurence  hostname)
           (string/after-first-occurence  "/" {:return? false})
           (string/before-first-occurence "?" {:return? true})
           (string/before-first-occurence "#" {:return? true})
           (string/starts-with!           "/"))))
