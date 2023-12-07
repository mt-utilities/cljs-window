
(ns window.location.env
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn uri
  ; @description
  ; Returns the actual URI read from the JS Window object.
  ;
  ; @usage
  ; (uri)
  ;
  ; @return (string)
  []
  (-> js/window .-location .-href))

(defn protocol
  ; @description
  ; Returns the actual protocol read from the JS Window object.
  ;
  ; @usage
  ; (protocol)
  ;
  ; @return (string)
  []
  (-> js/window .-location .-protocol))

(defn hostname
  ; @description
  ; Returns the actual hostname read from the JS Window object.
  ;
  ; @usage
  ; (hostname)
  ;
  ; @return (string)
  []
  (-> js/window .-location .-hostname))

(defn uri-base
  ; @description
  ; Returns the actual URI base (protocol and hostname) read from the JS Window object.
  ;
  ; @example
  ; (uri-base)
  ; =>
  ; "https://my-domain.com"
  ;
  ; @return (string)
  []
  (str (protocol) "//" (hostname)))

(defn uri-path
  ; @description
  ; Returns the actual URI path read from the JS Window object.
  ;
  ; @example
  ; (uri-path)
  ; =>
  ; "/my-path"
  ;
  ; @return (string)
  []
  (-> (uri)
      (string/after-first-occurence  (hostname))
      (string/after-first-occurence  "/" {:return? false})
      (string/before-first-occurence "?" {:return? true})
      (string/before-first-occurence "#" {:return? true})
      (string/starts-with!           "/")))
