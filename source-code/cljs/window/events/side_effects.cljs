
(ns window.events.side-effects)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn add-event-listener!
  ; @param (string) type
  ; @param (function) listener-f
  ; @param (DOM-element)(opt) target
  ; Default: js/window
  ;
  ; @usage
  ; (add-event-listener! "mousemove" (fn [event] ...))
  ([type listener-f]
   (add-event-listener! type listener-f js/window))

  ([type listener-f target]
   (.addEventListener target type listener-f false)))

(defn remove-event-listener!
  ; @param (string) type
  ; @param (function) listener-f
  ; @param (DOM-element)(opt) target
  ; Default: js/window
  ;
  ; @usage
  ; (def my-listener-f (fn [event]))
  ; (remove-event-listener! "mousemove" my-listener-f)
  ([type listener-f]
   (remove-event-listener! type listener-f js/window))

  ([type listener-f target]
   (.removeEventListener target type listener-f false)))
