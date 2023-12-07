
(ns window.api
    (:require [window.dimensions.env        :as dimensions.env]
              [window.dimensions.units      :as dimensions.units]
              [window.events.side-effects   :as events.side-effects]
              [window.history.side-effects  :as history.side-effects]
              [window.location.env          :as location.env]
              [window.location.side-effects :as location.side-effects]
              [window.navigator.env         :as navigator.env]
              [window.schedule.side-effects :as schedule.side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (window.dimensions.env)
(def viewport-height dimensions.env/viewport-height)
(def viewport-width  dimensions.env/viewport-width)
(def viewport-shape  dimensions.env/viewport-shape)

; @redirect (window.dimensions.units)
(def px->vh dimensions.units/px->vh)
(def px->vw dimensions.units/px->vw)
(def vh->px dimensions.units/vh->px)
(def vw->px dimensions.units/vw->px)

; @redirect (window.events.side-effects)
(def add-event-listener!    events.side-effects/add-event-listener!)
(def remove-event-listener! events.side-effects/remove-event-listener!)

; @redirect (window.history.side-effects)
(def go-back! history.side-effects/go-back!)

; @redirect (window.location.env)
(def uri      location.env/uri)
(def protocol location.env/protocol)
(def hostname location.env/hostname)
(def uri-base location.env/uri-base)
(def uri-path location.env/uri-path)

; @redirect (window.location.side-effects)
(def go-root!    location.side-effects/go-root!)
(def go-to!      location.side-effects/go-to!)
(def open-tab!   location.side-effects/open-tab!)
(def reload-tab! location.side-effects/reload-tab!)

; @redirect (window.navigator.env)
(def user-agent                 navigator.env/user-agent)
(def language                   navigator.env/language)
(def browser-online?            navigator.env/browser-online?)
(def browser-offline?           navigator.env/browser-offline?)
(def touch-events-api-detected? navigator.env/touch-events-api-detected?)

; @redirect (window.schedule.side-effects)
(def set-interval!   schedule.side-effects/set-interval!)
(def clear-interval! schedule.side-effects/clear-interval!)
(def set-timeout!    schedule.side-effects/set-timeout!)
(def abort-timeout!  schedule.side-effects/abort-timeout!)
