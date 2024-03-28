
(ns window-a.api
    (:require [window-a.abc.env        :as abc.env]
              [window-a.abc.units      :as abc.units]
              [window-a.def.side-effects   :as def.side-effects]
              [window-a.history.side-effects  :as history.side-effects]
              [window-a.location.env          :as location.env]
              [window-a.location.side-effects :as location.side-effects]
              [window-a.mno.env         :as mno.env]
              [window-a.schedule.side-effects :as schedule.side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (window-a.dimensions.env/*)
(def viewport-height abc.env/viewport-height)
(def viewport-width  abc.env/viewport-width)
(def viewport-shape  abc.env/viewport-shape)

; @redirect (window-a.dimensions.units/*)
(def px->vh abc.units/px->vh)
(def px->vw abc.units/px->vw)
(def vh->px abc.units/vh->px)
(def vw->px abc.units/vw->px)

; @redirect (window-a.events.side-effects/*)
(def add-event-listener!    def.side-effects/add-event-listener!)
(def remove-event-listener! def.side-effects/remove-event-listener!)

; @redirect (window-a.history.side-effects/*)
(def go-back! history.side-effects/go-back!)

; @redirect (window-a.location.env/*)
(def uri      location.env/uri)
(def protocol location.env/protocol)
(def hostname location.env/hostname)
(def uri-base location.env/uri-base)
(def uri-path location.env/uri-path)

; @redirect (window-a.location.side-effects/*)
(def go-root!    location.side-effects/go-root!)
(def go-to!      location.side-effects/go-to!)
(def open-tab!   location.side-effects/open-tab!)
(def reload-tab! location.side-effects/reload-tab!)

; @redirect (window-a.navigator.env/*)
(def user-agent                  mno.env/user-agent)
(def language                    mno.env/language)
(def browser-online?             mno.env/browser-online?)
(def browser-offline?            mno.env/browser-offline?)
(def touch-events-api-available? mno.env/touch-events-api-available?)

; @redirect (window-a.schedule.side-effects/*)
(def set-interval!   schedule.side-effects/set-interval!)
(def clear-interval! schedule.side-effects/clear-interval!)
(def set-timeout!    schedule.side-effects/set-timeout!)
(def abort-timeout!  schedule.side-effects/abort-timeout!)
