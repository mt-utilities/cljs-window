
(ns window.browser)

; A window.browser névtér eredetileg window.navigator névtér lett volna
;
; Error: Namespace "window.navigator" already declared.
; at Object.goog.provide
; at ...

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-user-agent
  ; @return (string)
  []
  (-> js/window .-navigator .-userAgent))

(defn get-language
  ; @return (string)
  []
  (-> js/window .-navigator .-language))

(defn browser-online?
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine boolean))

(defn browser-offline?
  ; @return (boolean)
  []
  (-> js/window .-navigator .-onLine not))
