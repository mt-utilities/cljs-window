
(ns window-a.schedule.side-effects
    (:require [common-state.api :as common-state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-interval!
  ; @description
  ; Registers an interval function optionally identified by the given ID.
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
        (common-state/assoc-state! :window :intervals interval-id ref))))

(defn clear-interval!
  ; @description
  ; Removes a previously registered interval function identified by the given ID.
  ;
  ; @param (keyword) interval-id
  ;
  ; @usage
  ; (clear-interval! :my-interval)
  [interval-id]
  (when-let [ref (common-state/get-state :window :intervals interval-id)]
            (.clearInterval js/window ref)
            (common-state/dissoc-state! :window :intervals interval-id)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-timeout!
  ; @description
  ; Registers a delayed function optionally identified by the given ID.
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
        (common-state/assoc-state! :window :timeouts timeout-id ref))))

(defn abort-timeout!
  ; @important
  ; This function is incomplete and may not behave as expected.
  ;
  ; @description
  ; Removes a previously registered delayed function identified by the given ID.
  ;
  ; @param (keyword) timeout-id
  ;
  ; @usage
  ; (abort-timeout! :my-timeout)
  [timeout-id]
  (when-let [ref (common-state/get-state :window :timeouts timeout-id)]
            ; TODO
            (common-state/dissoc-state! :window :timeouts timeout-id)))
