
(ns window.api
    (:require [window.location  :as location]
              [window.navigator :as navigator]
              [window.touch     :as touch]
              [window.units     :as units]
              [window.viewport  :as viewport]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; window.location
(def get-uri      location/get-uri)
(def get-protocol location/get-protocol)
(def get-hostname location/get-hostname)
(def get-uri-base location/get-uri-base)

; window.navigator
(def get-user-agent   navigator/get-user-agent)
(def get-language     navigator/get-language)
(def browser-online?  navigator/browser-online?)
(def browser-offline? navigator/browser-offline?)

; window.touch
(def touch-events-api-detected? touch/touch-events-api-detected?)

; window.units
(def px->vh units/px->vh)
(def px->vw units/px->vw)
(def vh->px units/vh->px)
(def vw->px units/vw->px)

; window.viewport
(def get-viewport-height      viewport/get-viewport-height)
(def get-viewport-width       viewport/get-viewport-width)
(def get-viewport-orientation viewport/get-viewport-orientation)
(def square-viewport?         viewport/square-viewport?)
(def landscape-viewport?      viewport/landscape-viewport?)
(def portrait-viewport?       viewport/portrait-viewport?)
