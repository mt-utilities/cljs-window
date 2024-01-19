
(ns window.schedule.side-effects
    (:require [window.schedule.state :as schedule.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-interval!
  ; @description
  ; Sets an interval function by using the JS Window object.
  ; By passing the ID, it can be cancelled with the clear-interval! function.
  ;
  ; @param (keyword)(opt) interval-id
  ; @param (function) f
  ; @param (ms) interval
  ;
  ; @usage
  ; (defn my-f [] (println "Hello again!"))
  ; (set-interval! :my-interval my-f 420)
  ([f interval]
   (.setInterval js/window f interval))

  ([interval-id f interval]
   (let [ref (.setInterval js/window f interval)]
        (swap! schedule.state/INTERVALS assoc interval-id ref))))

(defn clear-interval!
  ; @description
  ; Cancels a previously set interval function with the given ID.
  ;
  ; @param (keyword) interval-id
  ;
  ; @usage
  ; (clear-interval! :my-interval)
  [interval-id]
  (when-let [ref (interval-id @schedule.state/INTERVALS)]
            (.clearInterval js/window ref)
            (swap! schedule.state/INTERVALS dissoc interval-id)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-timeout!
  ; @description
  ; Sets a delayed function by using the JS Window object.
  ; By passing the ID, it can be aborted with the abort-timeout! function.
  ;
  ; @param (keyword)(opt) timeout-id
  ; @param (function) f
  ; @param (ms) timeout
  ;
  ; @usage
  ; (defn my-f [] (println "Long time no see!"))
  ; (set-timeout! :my-timeout my-f 420)
  ([f timeout]
   (.setTimeout js/window f timeout))

  ([timeout-id f timeout]
   (let [ref (.setTimeout js/window f timeout)]
        (swap! schedule.state/TIMEOUTS assoc timeout-id ref))))

(defn abort-timeout!
  ; @important
  ; This function is incomplete and may not behave as expected.
  ;
  ; @description
  ; Aborts a previously set timeout function with the given ID.
  ;
  ; @param (keyword) timeout-id
  ;
  ; @usage
  ; (abort-timeout! :my-timeout)
  [timeout-id]
  (when-let [ref (timeout-id @schedule.state/TIMEOUTS)]
            ; TODO
            (swap! schedule.state/TIMEOUTS dissoc timeout-id)))
