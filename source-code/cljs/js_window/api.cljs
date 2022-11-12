
(ns js-window.api
    (:require [js-window.go        :as go]
              [js-window.location  :as location]
              [js-window.navigator :as navigator]
              [js-window.tab       :as tab]
              [js-window.touch     :as touch]
              [js-window.units     :as units]
              [js-window.viewport  :as viewport]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; js-window.go
(def go-root! go/go-root!)
(def go-back! go/go-back!)
(def go-to!   go/go-to!)

; js-window.location
(def get-uri      location/get-uri)
(def get-protocol location/get-protocol)
(def get-hostname location/get-hostname)
(def get-uri-base location/get-uri-base)
(def get-uri-path location/get-uri-path)

; js-window.navigator
(def get-user-agent   navigator/get-user-agent)
(def get-language     navigator/get-language)
(def browser-online?  navigator/browser-online?)
(def browser-offline? navigator/browser-offline?)

; js-window.tab
(def open-tab!   tab/open-tab!)
(def reload-tab! tab/reload-tab!)

; js-window.touch
(def touch-events-api-detected? touch/touch-events-api-detected?)

; js-window.units
(def px->vh units/px->vh)
(def px->vw units/px->vw)
(def vh->px units/vh->px)
(def vw->px units/vw->px)

; js-window.viewport
(def get-viewport-height      viewport/get-viewport-height)
(def get-viewport-width       viewport/get-viewport-width)
(def get-viewport-orientation viewport/get-viewport-orientation)
(def square-viewport?         viewport/square-viewport?)
(def landscape-viewport?      viewport/landscape-viewport?)
(def portrait-viewport?       viewport/portrait-viewport?)
