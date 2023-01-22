
# window.api ClojureScript namespace

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > window.api

### Index

- [abort-timeout!](#abort-timeout)

- [add-event-listener!](#add-event-listener)

- [browser-offline?](#browser-offline)

- [browser-online?](#browser-online)

- [clear-interval!](#clear-interval)

- [go-back!](#go-back)

- [go-root!](#go-root)

- [go-to!](#go-to)

- [hostname](#hostname)

- [language](#language)

- [open-tab!](#open-tab)

- [protocol](#protocol)

- [px->vh](#px-vh)

- [px->vw](#px-vw)

- [reload-tab!](#reload-tab)

- [remove-event-listener!](#remove-event-listener)

- [set-interval!](#set-interval)

- [set-timeout!](#set-timeout)

- [touch-events-api-detected?](#touch-events-api-detected)

- [uri](#uri)

- [uri-base](#uri-base)

- [uri-path](#uri-path)

- [user-agent](#user-agent)

- [vh->px](#vh-px)

- [viewport-height](#viewport-height)

- [viewport-shape](#viewport-shape)

- [viewport-width](#viewport-width)

- [vw->px](#vw-px)

### abort-timeout!

```
@description
Aborts a previously set timeout function with the given ID.
```

```
@param (keyword) timeout-id
```

```
@usage
(abort-timeout! :my-timeout)
```

<details>
<summary>Source code</summary>

```
(defn abort-timeout!
  [timeout-id]
  (when-let [ref (timeout-id @schedule.state/TIMEOUTS)]
            (swap! schedule.state/TIMEOUTS dissoc timeout-id)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [abort-timeout!]]))

(window.api/abort-timeout! ...)
(abort-timeout!            ...)
```

</details>

---

### add-event-listener!

```
@param (string) type
@param (function) listener-f
@param (DOM-element)(opt) target
Default: js/window
```

```
@usage
(add-event-listener! "mousemove" (fn [event] ...))
```

<details>
<summary>Source code</summary>

```
(defn add-event-listener!
  ([type listener-f]
   (add-event-listener! type listener-f js/window))

  ([type listener-f target]
   (.addEventListener target type listener-f false)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [add-event-listener!]]))

(window.api/add-event-listener! ...)
(add-event-listener!            ...)
```

</details>

---

### browser-offline?

```
@description
Returns true if the browser is NOT connected to the internet read from the JS Window object.
```

```
@usage
(browser-offline?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn browser-offline?
  []
  (-> js/window .-navigator .-onLine not))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [browser-offline?]]))

(window.api/browser-offline?)
(browser-offline?)
```

</details>

---

### browser-online?

```
@description
Returns true if the browser is connected to the internet read from the JS Window object.
```

```
@usage
(browser-online?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn browser-online?
  []
  (-> js/window .-navigator .-onLine boolean))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [browser-online?]]))

(window.api/browser-online?)
(browser-online?)
```

</details>

---

### clear-interval!

```
@description
Cancels a previously set interval function with the given ID.
```

```
@param (keyword) interval-id
```

```
@usage
(clear-interval! :my-interval)
```

<details>
<summary>Source code</summary>

```
(defn clear-interval!
  [interval-id]
  (when-let [ref (interval-id @schedule.state/INTERVALS)]
            (.clearInterval js/window ref)
            (swap! schedule.state/INTERVALS dissoc interval-id)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [clear-interval!]]))

(window.api/clear-interval! ...)
(clear-interval!            ...)
```

</details>

---

### go-back!

```
@description
Navigates the page back in the route history by using the JS Window object.
```

```
@usage
(go-back!)
```

<details>
<summary>Source code</summary>

```
(defn go-back!
  [_]
  (-> js/window .-history .back))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [go-back!]]))

(window.api/go-back!)
(go-back!)
```

</details>

---

### go-root!

```
@description
Navigates the page to the root path ("/") by using the JS Window object.
```

```
@usage
(go-root!)
```

<details>
<summary>Source code</summary>

```
(defn go-root!
  [_]
  (set! (-> js/window .-location .-href) "/"))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [go-root!]]))

(window.api/go-root!)
(go-root!)
```

</details>

---

### go-to!

```
@description
Navigates the page to the given path or URI by using the JS Window object.
```

```
@param (string) uri
```

```
@usage
(go-to! "my-link")
```

```
@usage
(go-to! "www.my-site.com/my-link")
```

<details>
<summary>Source code</summary>

```
(defn go-to!
  [uri]
  (set! (-> js/window .-location .-href) uri))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [go-to!]]))

(window.api/go-to! ...)
(go-to!            ...)
```

</details>

---

### hostname

```
@description
Returns the actual hostname read from the JS Window object.
```

```
@usage
(hostname)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn hostname
  []
  (-> js/window .-location .-hostname))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [hostname]]))

(window.api/hostname)
(hostname)
```

</details>

---

### language

```
@description
Returns the preferred language of the user, usually the language of the
browser UI read from the JS Window object.
```

```
@usage
(language)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn language
  []
  (-> js/window .-navigator .-language))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [language]]))

(window.api/language)
(language)
```

</details>

---

### open-tab!

```
@description
Opens a new browser tab by using the JS Window object.
```

```
@param (string) uri
```

```
@usage
(open-tab! "www.my-site.com/my-link")
```

<details>
<summary>Source code</summary>

```
(defn open-tab!
  [uri]
  (.open js/window uri "_blank"))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [open-tab!]]))

(window.api/open-tab! ...)
(open-tab!            ...)
```

</details>

---

### protocol

```
@description
Returns the actual protocol read from the JS Window object.
```

```
@usage
(protocol)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn protocol
  []
  (-> js/window .-location .-protocol))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [protocol]]))

(window.api/protocol)
(protocol)
```

</details>

---

### px->vh

```
@description
Translate the given pixel value into actual VH value by using the viewport
height read from the JS Window object.
```

```
@param (px) n
```

```
@usage
(px->vh 420)
```

```
@return (vh)
```

<details>
<summary>Source code</summary>

```
(defn px->vh
  [n]
  (-> n (/ (-> js/window .-innerHeight (/ 100))) math/floor))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [px->vh]]))

(window.api/px->vh ...)
(px->vh            ...)
```

</details>

---

### px->vw

```
@description
Translate the given pixel value into actual VW value by using the viewport
width read from the JS Window object.
```

```
@param (px) n
```

```
@usage
(px->vw 420)
```

```
@return (vw)
```

<details>
<summary>Source code</summary>

```
(defn px->vw
  [n]
  (-> n (/ (-> js/window .-innerWidth (/ 100))) math/floor))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [px->vw]]))

(window.api/px->vw ...)
(px->vw            ...)
```

</details>

---

### reload-tab!

```
@description
Reloads the browser tab by using the JS Window object.
```

```
@usage
(reload-tab!)
```

<details>
<summary>Source code</summary>

```
(defn reload-tab!
  []
  (.reload js/window.location true))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [reload-tab!]]))

(window.api/reload-tab!)
(reload-tab!)
```

</details>

---

### remove-event-listener!

```
@param (string) type
@param (function) listener-f
@param (DOM-element)(opt) target
Default: js/window
```

```
@usage
(def my-listener-f (fn [event]))
(remove-event-listener! "mousemove" my-listener-f)
```

<details>
<summary>Source code</summary>

```
(defn remove-event-listener!
  ([type listener-f]
   (remove-event-listener! type listener-f js/window))

  ([type listener-f target]
   (.removeEventListener target type listener-f false)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [remove-event-listener!]]))

(window.api/remove-event-listener! ...)
(remove-event-listener!            ...)
```

</details>

---

### set-interval!

```
@description
Sets an interval function by using the JS Window object.
By passing the ID, it can be cancelled with the clear-interval! function.
```

```
@param (keyword)(opt) interval-id
@param (function) f
@param (ms) interval
```

```
@usage
(defn my-f [] (println "Hello again!"))
(set-interval! :my-interval my-f 420)
```

<details>
<summary>Source code</summary>

```
(defn set-interval!
  ([f interval]
   (.setInterval js/window f interval))

  ([interval-id f interval]
   (let [ref (.setInterval js/window f interval)]
        (swap! schedule.state/INTERVALS assoc interval-id ref))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [set-interval!]]))

(window.api/set-interval! ...)
(set-interval!            ...)
```

</details>

---

### set-timeout!

```
@description
Sets a delayed function by using the JS Window object.
By passing the ID, it can be aborted with the abort-timeout! function.
```

```
@param (keyword)(opt) timeout-id
@param (function) f
@param (ms) timeout
```

```
@usage
(defn my-f [] (println "Long time no see!"))
(set-timeout! :my-timeout my-f 420)
```

<details>
<summary>Source code</summary>

```
(defn set-timeout!
  ([f timeout]
   (.setTimeout js/window f timeout))

  ([timeout-id f timeout]
   (let [ref (.setTimeout js/window f timeout)]
        (swap! schedule.state/TIMEOUTS assoc timeout-id ref))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [set-timeout!]]))

(window.api/set-timeout! ...)
(set-timeout!            ...)
```

</details>

---

### touch-events-api-detected?

```
@description
Returns true if the page is using touch pointer device determined by using
the JS Window object.
```

```
@usage
(touch-events-api-detected?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn touch-events-api-detected?
  []
  (boolean (or (.hasOwnProperty js/window "ontouchstart")
               (-> js/window .-navigator .-maxTouchPoints   (> 0))
               (-> js/window .-navigator .-msMaxTouchPoints (> 0))
               (and (.-DocumentTouch js/window)
                    (instance? "DocumentTouch" js/document)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [touch-events-api-detected?]]))

(window.api/touch-events-api-detected?)
(touch-events-api-detected?)
```

</details>

---

### uri

```
@description
Returns the actual URI read from the JS Window object.
```

```
@usage
(uri)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn uri
  []
  (-> js/window .-location .-href))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [uri]]))

(window.api/uri)
(uri)
```

</details>

---

### uri-base

```
@description
Returns the actual URI base (protocol and hostname) read from the JS Window object.
```

```
@example
(uri-base)
=>
"https://my-domain.com"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn uri-base
  []
  (str (protocol) "//" (hostname)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [uri-base]]))

(window.api/uri-base)
(uri-base)
```

</details>

---

### uri-path

```
@description
Returns the actual URI path read from the JS Window object.
```

```
@example
(uri-path)
=>
"/my-path"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn uri-path
  []
  (-> (uri)
      (string/after-first-occurence  (hostname))
      (string/after-first-occurence  "/" {:return? false})
      (string/before-first-occurence "?" {:return? true})
      (string/before-first-occurence "#" {:return? true})
      (string/starts-with!           "/")))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [uri-path]]))

(window.api/uri-path)
(uri-path)
```

</details>

---

### user-agent

```
@description
Returns the actual user agent read from the JS Window object.
```

```
@usage
(user-agent)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn user-agent
  []
  (-> js/window .-navigator .-userAgent))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [user-agent]]))

(window.api/user-agent)
(user-agent)
```

</details>

---

### vh->px

```
@description
Translate the given VH value into actual pixel value by using the viewport
height read from the JS Window object.
```

```
@param (vh) n
```

```
@usage
(vh->px 42)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn vh->px
  [n]
  (-> n (* (-> js/window .-innerHeight (/ 100))) math/floor))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [vh->px]]))

(window.api/vh->px ...)
(vh->px            ...)
```

</details>

---

### viewport-height

```
@description
Returns the actual viewport height read from the JS Window object.
```

```
@usage
(viewport-height)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn viewport-height
  []
  (.-innerHeight js/window))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [viewport-height]]))

(window.api/viewport-height)
(viewport-height)
```

</details>

---

### viewport-shape

```
@description
Returns the actual viewport shape determined by using viewport dimensions
read from the JS Window object.
```

```
@usage
(viewport-shape)
```

```
@return (keyword)
:landscape, :portrait, :square
```

<details>
<summary>Source code</summary>

```
(defn viewport-shape
  []
  (let [viewport-height (.-innerHeight js/window)
        viewport-width  (.-innerWidth  js/window)]
       (cond (< viewport-height viewport-width) :landscape
             (> viewport-height viewport-width) :portrait
             :else :square)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [viewport-shape]]))

(window.api/viewport-shape)
(viewport-shape)
```

</details>

---

### viewport-width

```
@description
Returns the actual viewport width read from the JS Window object.
```

```
@usage
(viewport-width)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn viewport-width
  []
  (.-innerWidth js/window))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [viewport-width]]))

(window.api/viewport-width)
(viewport-width)
```

</details>

---

### vw->px

```
@description
Translate the given VH value into actual pixel value by using the viewport
width read from the JS Window object.
```

```
@param (vw) n
```

```
@usage
(vw->px 42)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn vw->px
  [n]
  (-> n (* (-> js/window .-innerWidth (/ 100))) math/floor))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window.api :refer [vw->px]]))

(window.api/vw->px ...)
(vw->px            ...)
```

</details>

---

This documentation is generated by the [docs-api](https://github.com/bithandshake/docs-api) engine

