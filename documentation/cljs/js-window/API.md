
# <strong>js-window.api</strong> namespace

<strong>[README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > </strong>source-code/cljs/js_window/api.cljs

### browser-offline?

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
(ns my-namespace (:require [js-window.api :refer [browser-offline?]]))

(js-window.api/browser-offline?)
(browser-offline?)
```

</details>

---

### browser-online?

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
(ns my-namespace (:require [js-window.api :refer [browser-online?]]))

(js-window.api/browser-online?)
(browser-online?)
```

</details>

---

### get-hostname

```
@usage
(get-hostname)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-hostname
  []
  (-> js/window .-location .-hostname))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-hostname]]))

(js-window.api/get-hostname)
(get-hostname)
```

</details>

---

### get-language

```
@usage
(get-language)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-language
  []
  (-> js/window .-navigator .-language))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-language]]))

(js-window.api/get-language)
(get-language)
```

</details>

---

### get-protocol

```
@usage
(get-protocol)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-protocol
  []
  (-> js/window .-location .-protocol))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-protocol]]))

(js-window.api/get-protocol)
(get-protocol)
```

</details>

---

### get-uri

```
@usage
(get-uri)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-uri
  []
  (-> js/window .-location .-href))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-uri]]))

(js-window.api/get-uri)
(get-uri)
```

</details>

---

### get-uri-base

```
@example
(get-uri-base)
=>
"https://my-domain.com"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-uri-base
  []
  (let [protocol (get-protocol)
        hostname (get-hostname)]
       (str protocol "//" hostname)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-uri-base]]))

(js-window.api/get-uri-base)
(get-uri-base)
```

</details>

---

### get-uri-path

```
@example
(get-uri-path)
=>
"/my-path"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-uri-path
  []
  (let [hostname (get-hostname)]
       (-> (get-uri)
           (string/after-first-occurence  hostname)
           (string/after-first-occurence  "/" {:return? false})
           (string/before-first-occurence "?" {:return? true})
           (string/before-first-occurence "#" {:return? true})
           (string/starts-with!           "/"))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-uri-path]]))

(js-window.api/get-uri-path)
(get-uri-path)
```

</details>

---

### get-user-agent

```
@usage
(get-user-agent)
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn get-user-agent
  []
  (-> js/window .-navigator .-userAgent))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-user-agent]]))

(js-window.api/get-user-agent)
(get-user-agent)
```

</details>

---

### get-viewport-height

```
@usage
(get-viewport-height)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-viewport-height
  []
  (.-innerHeight js/window))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-viewport-height]]))

(js-window.api/get-viewport-height)
(get-viewport-height)
```

</details>

---

### get-viewport-orientation

```
@usage
(get-viewport-orientation)
```

```
@return (keyword)
:landscape, :portrait
```

<details>
<summary>Source code</summary>

```
(defn get-viewport-orientation
  []
  (if (> (.-innerHeight js/window)
         (.-innerWidth  js/window))
      (return :portrait)
      (return :landscape)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-viewport-orientation]]))

(js-window.api/get-viewport-orientation)
(get-viewport-orientation)
```

</details>

---

### get-viewport-width

```
@usage
(get-viewport-width)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-viewport-width
  []
  (.-innerWidth js/window))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [get-viewport-width]]))

(js-window.api/get-viewport-width)
(get-viewport-width)
```

</details>

---

### go-back!

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
(ns my-namespace (:require [js-window.api :refer [go-back!]]))

(js-window.api/go-back!)
(go-back!)
```

</details>

---

### go-root!

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
(ns my-namespace (:require [js-window.api :refer [go-root!]]))

(js-window.api/go-root!)
(go-root!)
```

</details>

---

### go-to!

```
@param (string) uri
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
(ns my-namespace (:require [js-window.api :refer [go-to!]]))

(js-window.api/go-to! ...)
(go-to!               ...)
```

</details>

---

### landscape-viewport?

```
@usage
(landscape-viewport?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn landscape-viewport?
  []
  (< (.-innerHeight js/window)
     (.-innerWidth  js/window)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [landscape-viewport?]]))

(js-window.api/landscape-viewport?)
(landscape-viewport?)
```

</details>

---

### open-tab!

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
(ns my-namespace (:require [js-window.api :refer [open-tab!]]))

(js-window.api/open-tab! ...)
(open-tab!               ...)
```

</details>

---

### portrait-viewport?

```
@usage
(portrait-viewport?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn portrait-viewport?
  []
  (> (.-innerHeight js/window)
     (.-innerWidth  js/window)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [portrait-viewport?]]))

(js-window.api/portrait-viewport?)
(portrait-viewport?)
```

</details>

---

### px->vh

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
(ns my-namespace (:require [js-window.api :refer [px->vh]]))

(js-window.api/px->vh ...)
(px->vh               ...)
```

</details>

---

### px->vw

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
(ns my-namespace (:require [js-window.api :refer [px->vw]]))

(js-window.api/px->vw ...)
(px->vw               ...)
```

</details>

---

### reload-tab!

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
(ns my-namespace (:require [js-window.api :refer [reload-tab!]]))

(js-window.api/reload-tab!)
(reload-tab!)
```

</details>

---

### square-viewport?

```
@usage
(square-viewport?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn square-viewport?
  []
  (= (.-innerHeight js/window)
     (.-innerWidth  js/window)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [js-window.api :refer [square-viewport?]]))

(js-window.api/square-viewport?)
(square-viewport?)
```

</details>

---

### touch-events-api-detected?

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
(ns my-namespace (:require [js-window.api :refer [touch-events-api-detected?]]))

(js-window.api/touch-events-api-detected?)
(touch-events-api-detected?)
```

</details>

---

### vh->px

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
(ns my-namespace (:require [js-window.api :refer [vh->px]]))

(js-window.api/vh->px ...)
(vh->px               ...)
```

</details>

---

### vw->px

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
(ns my-namespace (:require [js-window.api :refer [vw->px]]))

(js-window.api/vw->px ...)
(vw->px               ...)
```

</details>
