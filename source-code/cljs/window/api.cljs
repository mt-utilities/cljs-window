
(ns window.api
    (:require [window.browser  :as browser]
              [window.go       :as go]
              [window.tab      :as tab]
              [window.touch    :as touch]
              [window.units    :as units]
              [window.uri      :as uri]
              [window.viewport :as viewport]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; window.browser
(def get-user-agent   browser/get-user-agent)
(def get-language     browser/get-language)
(def browser-online?  browser/browser-online?)
(def browser-offline? browser/browser-offline?)

; window.go
(def go-root! go/go-root!)
(def go-back! go/go-back!)
(def go-to!   go/go-to!)

; window.tab
(def open-tab!   tab/open-tab!)
(def reload-tab! tab/reload-tab!)

; window.touch
(def touch-events-api-detected? touch/touch-events-api-detected?)

; window.units
(def px->vh units/px->vh)
(def px->vw units/px->vw)
(def vh->px units/vh->px)
(def vw->px units/vw->px)

; window.uri
(def get-uri      uri/get-uri)
(def get-protocol uri/get-protocol)
(def get-hostname uri/get-hostname)
(def get-uri-base uri/get-uri-base)

; window.viewport
(def get-viewport-height      viewport/get-viewport-height)
(def get-viewport-width       viewport/get-viewport-width)
(def get-viewport-orientation viewport/get-viewport-orientation)
(def square-viewport?         viewport/square-viewport?)
(def landscape-viewport?      viewport/landscape-viewport?)
(def portrait-viewport?       viewport/portrait-viewport?)
