
(ns window.api
    (:require [window.dimensions.helpers    :as dimensions.helpers]
              [window.dimensions.units      :as dimensions.units]
              [window.events.side-effects   :as events.side-effects]
              [window.history.side-effects  :as history.side-effects]
              [window.location.helpers      :as location.helpers]
              [window.location.side-effects :as location.side-effects]
              [window.navigator.helpers     :as navigator.helpers]
              [window.schedule.side-effects :as schedule.side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; window.dimensions.helpers
(def viewport-height dimensions.helpers/viewport-height)
(def viewport-width  dimensions.helpers/viewport-width)
(def viewport-shape  dimensions.helpers/viewport-shape)

; window.dimensions.units
(def px->vh dimensions.units/px->vh)
(def px->vw dimensions.units/px->vw)
(def vh->px dimensions.units/vh->px)
(def vw->px dimensions.units/vw->px)

; window.events.side-effects
(def add-event-listener!    events.side-effects/add-event-listener!)
(def remove-event-listener! events.side-effects/remove-event-listener!)

; window.history.side-effects
(def go-back! history.side-effects/go-back!)

; window.location.helpers
(def uri      location.helpers/uri)
(def protocol location.helpers/protocol)
(def hostname location.helpers/hostname)
(def uri-base location.helpers/uri-base)
(def uri-path location.helpers/uri-path)

; window.location.side-effects
(def go-root!    location.side-effects/go-root!)
(def go-to!      location.side-effects/go-to!)
(def open-tab!   location.side-effects/open-tab!)
(def reload-tab! location.side-effects/reload-tab!)

; window.navigator.helpers
(def user-agent                 navigator.helpers/user-agent)
(def language                   navigator.helpers/language)
(def browser-online?            navigator.helpers/browser-online?)
(def browser-offline?           navigator.helpers/browser-offline?)
(def touch-events-api-detected? navigator.helpers/touch-events-api-detected?)

; window.schedule.side-effects
(def set-interval!   schedule.side-effects/set-interval!)
(def clear-interval! schedule.side-effects/clear-interval!)
(def set-timeout!    schedule.side-effects/set-timeout!)
(def abort-timeout!  schedule.side-effects/abort-timeout!)
