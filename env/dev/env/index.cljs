(ns env.index
  (:require [env.dev :as dev]))

;; undo main.js goog preamble hack
(set! js/window.goog js/undefined)

(-> (js/require "figwheel-bridge")
    (.withModules #js {"react-apollo" (js/require "react-apollo"), "apollo-client" (js/require "apollo-client"), "graphql-tag" (js/require "graphql-tag"), "react" (js/require "react"), "react-native" (js/require "react-native"), "exponent" (js/require "exponent"), "./assets/images/cljs.png" (js/require "../../assets/images/cljs.png")}
)
    (.start "main"))
