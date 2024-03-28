
(ns window-a.def.side-effects)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn add-event-listener!
  ; @description
  ; Registers an event listener function attached to the given target element.
  ;
  ; @param (string) type
  ; @param (function) listener-f
  ; @param (DOM Element object)(opt) target-element
  ; Default: js/window
  ;
  ; @usage
  ; (add-event-listener! "mousemove" (fn [event] ...))
  ([type listener-f]
   (add-event-listener! type listener-f js/window))

  ([type listener-f target-element]
   (.addEventListener target-element type listener-f false)))

(defn remove-event-listener!
  ; @description
  ; Removes a specific event listener function of to the given target element.
  ;
  ; @param (string) type
  ; @param (function) listener-f
  ; @param (DOM Element object)(opt) target-element
  ; Default: js/window
  ;
  ; @usage
  ; (def my-listener-f (fn [event]))
  ; (remove-event-listener! "mousemove" my-listener-f)
  ([type listener-f]
   (remove-event-listener! type listener-f js/window))

  ([type listener-f target-element]
   (.removeEventListener target-element type listener-f false)))
