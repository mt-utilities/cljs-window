
# BUG#0081

Compiling with Shadow-CLJS including advanced optimization, naming namespaces as 'window.*' should be avoided!

In compiled JS files the following error might occur:
- Uncaught Error: addEventListener and attachEvent are unavailable.

# BUG#0082

Naming a namespace as 'window.location' leads to the following error:
- Error: Namespace "window.location" already declared.
  at Object.goog.provide
  at ...

# BUG#0083    

Naming a namespace as 'window.navigator' leads to the following error:
- Error: Namespace "window.navigator" already declared.
  at Object.goog.provide
  at ...
