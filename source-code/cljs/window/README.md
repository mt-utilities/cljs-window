
# BUG#0081

Compiling with Shadow-CLJS and advanced optimizations, window.* namespace
naming should be avoided!

In compiled JS files the following error might be occurred:
- Uncaught Error: addEventListener and attachEvent are unavailable.

# BUG#0082

By naming a namespace as window.location, the compiled JS files throw the following error:
- Error: Namespace "window.location" already declared.
  at Object.goog.provide
  at ...

# BUG#0083    

By naming a namespace as window.navigator, the compiled JS files throw the following error:
- Error: Namespace "window.navigator" already declared.
  at Object.goog.provide
  at ...
