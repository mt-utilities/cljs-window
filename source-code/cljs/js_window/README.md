
# BUG#0081

:prod fordításkor, ha a projektben az accountant.core névtér is behívásra került,
akkor a window.* névtér elnevezések használata miatt a .js fájlok nem futottak le!
- Uncaught Error: addEventListener and attachEvent are unavailable.

# BUG#0082

A window.location névtér használatakor a következő hiba miatt a .js fájlok nem futottak le.
- Error: Namespace "window.location" already declared.
  at Object.goog.provide
  at ...

# BUG#0083    

A window.navigator névtér használatakor a következő hiba miatt a .js fájlok nem futottak le.
- Error: Namespace "window.navigator" already declared.
  at Object.goog.provide
  at ...
