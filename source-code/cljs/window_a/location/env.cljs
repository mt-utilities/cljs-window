
(ns window-a.location.env
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn uri
  ; @description
  ; Returns the actual URI.
  ;
  ; @usage
  ; (uri)
  ; =>
  ; "https://my-domain.com/my-path"
  ;
  ; @return (string)
  []
  (-> js/window .-location .-href))

(defn protocol
  ; @description
  ; Returns the protocol of the actual URI.
  ;
  ; @usage
  ; (protocol)
  ; =>
  ; "https:"
  ;
  ; @return (string)
  []
  (-> js/window .-location .-protocol))

(defn hostname
  ; @description
  ; Returns the hostname of the actual URI.
  ;
  ; @usage
  ; (hostname)
  ; =>
  ; "my-domain.com"
  ;
  ; @return (string)
  []
  (-> js/window .-location .-hostname))

(defn uri-base
  ; @description
  ; Returns the URI base (protocol and hostname) of the actual URI.
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
  ; Returns the path of the actual URI.
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
      (string/start-with             "/")))
