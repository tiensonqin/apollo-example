(ns apollo-example.core
    (:require [reagent.core :as r :refer [atom]]
              [re-frame.core :refer [subscribe dispatch dispatch-sync]]
              [apollo-example.handlers]
              [apollo-example.subs]
              [cljs-exponent.reagent :refer [text view image touchable-highlight] :as rn]
              [goog.object :as gobj]
              [apollo-example.query :as query]))

;; apollo-client
(def ReactApollo (js/require "react-apollo"))
(def graphql (gobj/get ReactApollo "graphql"))
(def apollo-provider (r/adapt-react-class (gobj/get ReactApollo "ApolloProvider")))
(def ApolloClient (js/require "apollo-client"))
(def apollo-client (aget ApolloClient "ApolloClient"))
(def create-network-interface (aget ApolloClient "createNetworkInterface"))

(def network-interface (create-network-interface (clj->js {:uri "https://graphql-pokemon.now.sh/"})))
(def client (new apollo-client (clj->js {:networkInterface network-interface})))

(def gql (js/require "graphql-tag"))

;; with-pokemon :: wrapped-component -> a GraphQL component
(def with-pokemon (graphql query/query-json (clj->js {:options {:variables {:name "charmander"}}})))

(defn alert [title]
  (.alert rn/alert title))

(defn keywordize
  [obj]
  (when obj
    (js->clj obj :keywordize-keys true)))

(def styles {:container {:flex 1
                         :justify-content "center"
                         :align-items "center"}
             :welcome {:font-size 20
                       :text-align "center"
                       :margin 10}})

(defn pokemon-cp
  [{data :data}]
  (let [{:keys [loading pokemon error]} (keywordize data)]
    (if loading
      [view {:style (:container styles)}
       [text {:style (:welcome styles)}
        "Loading"]]

      [view {:style (:container styles)}
       (when pokemon
         [view
          [text {:style (:welcome styles)}
           (:name pokemon)]
          [image {:source {:uri (:image pokemon)}
                  :style {:width 200
                          :height 225}}]])])))

(def pokemon (-> (r/reactify-component pokemon-cp)
                 (with-pokemon)
                 (r/adapt-react-class)))

(defn app-root []
  [apollo-provider {:client client}
   [pokemon]])

(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent rn/app-registry "main" #(r/reactify-component app-root)))
