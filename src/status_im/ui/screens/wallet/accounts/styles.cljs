(ns status-im.ui.screens.wallet.accounts.styles
  (:require [status-im.ui.components.colors :as colors]
            [status-im.ui.components.reanimated :as reanimated]))

(defn topbar [{:keys [value offset inset-top]}]
  {:flex-direction     :row
   :padding-horizontal 8
   :left               0
   :right              0
   :padding-top        inset-top
   :shadow-offset      {:width 0 :height 4}
   :shadow-radius      16
   :shadow-opacity     (reanimated/interpolate value
                                               {:inputRange  [0 offset]
                                                :outputRange [0 1]
                                                :extrapolate (:clamp reanimated/extrapolate)})
   :z-index            2
   :background-color   colors/white
   :shadow-color       (if (colors/dark?)
                         "rgba(0, 0, 0, 0.75)"
                         "rgba(0, 9, 26, 0.12)")})

(defn card-common []
  {:margin-vertical   16
   :margin-horizontal 8
   :width             156
   :height            145
   :shadow-offset     {:width 0 :height 2}
   :shadow-radius     8
   :shadow-opacity    1
   :shadow-color      (if (colors/dark?)
                        "rgba(0, 0, 0, 0.75)"
                        "rgba(0, 9, 26, 0.12)")
   :elevation         3
   :border-radius     8})

(defn card [color]
  (merge (card-common)
         {:background-color   color
          :justify-content    :space-between
          :padding-horizontal 12
          :padding-top        12
          :padding-bottom     6}))

(defn add-card []
  (merge (card-common)
         {:background-color colors/white
          :justify-content  :center
          :align-items      :center}))

(def send-button-container
  {:position        :absolute
   :z-index         2
   :align-items     :center
   :justify-content :center
   :left            0
   :right           0
   :bottom          16
   :height          40})

(defn send-button []
  {:width            40
   :height           40
   :background-color colors/blue
   :border-radius    20
   :align-items      :center
   :justify-content  :center
   :shadow-offset    {:width 0 :height 1}
   :shadow-radius    6
   :shadow-opacity   1
   :shadow-color     (if (colors/dark?)
                       "rgba(0, 0, 0, 0.75)"
                       "rgba(0, 12, 63, 0.2)")
   :elevation        2})
