(ns testest.core
  (:use compojure.core
        [hiccup core page element]
        ring.middleware.json-params
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [clj-json.core :as json]))

(defn post-boiler [json]
  (str "$(document).ready(function() {
            $.post(\"/\", " json ", function(){});
          });"))

(defn index-page []
  (html
   [:div {:id "test"}
    [:p "test"]
    (javascript-tag (post-boiler "\"algodon\""))]))

(def somedata
  (let [valores  (map #(concat (rand-nth [ ["x" "y" "z"] ["a" "b" "c"]]) %) (partition 4 (range 1 84)))]
    (for [i valores]
      (zipmap [:uno :dos :tres :cuatro :cinco :seis :siete :ocho] i))))

(def onclick
  (str "$('#" "olakease" "').children('#' + $('#laa').val()).show()"))

(def listofas
  [:form
   (include-js "http://code.jquery.com/jquery-2.0.0.min.js")
   [:select {:id "laa"}
    (for [i (distinct (map :uno somedata))]
      [:option {:value i} i])]
   [:input {:type "button" :value "Sow Value" :onClick onclick}]])

(def divss 
  [:div {:id "olakease"}
   [:div {:id "a" :style "display: none;"}
    [:img {:src "http://www.actualidadjuvenil.com/wp-content/uploads/2012/12/ola-ke-ase-significado-300x300.jpg"}]]
   [:div {:id "x" :style "display: none;"}
    [:p "hola ke ase?"]]])


(defroutes main-routes
  (GET "/" [] (html listofas divss))
  (POST "/" [sent-object]
    (println "got:" sent-object "from jquery")
    (if sent-object (str sent-object) "")
    (route/resources "/"))
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))
