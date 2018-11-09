;; NOTE: This namespace covers the following api https://deckofcardsapi.com/

(ns deck-of-cards-api-clj.data
  (:require [org.httpkit.client :as http]
            [clj-http.client :as client]
            [cheshire.core :refer :all]))

;;;;;;;;;;;;;;;;
;; deck-of-cards-api
;;;;;;;;;;;;;;;;


;; TODO: default value is 1
(defn shuffle-the-cards-api [deck-count]
  (str "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=" (str deck-count)))

(parse-string
 (:body
  (client/get
   (shuffle-the-cards-api 1)
   {:accept :json})))

;;;;;;;;;;;;;;;;;


;; NOTE: replace <<deck_id>> with "new" to create a shuffled deck and draw cards from that deck in the same request.
(defn draw-a-card-api [deck-id card-count]
  (str "https://deckofcardsapi.com/api/deck/" (str deck-id) "/draw/?count=" (str card-count)))

;;;;;;;;;;;;;;;;;

;; Reshuffle the Cards:

(defn reshuffle-the-cards-api [deck-id]
  (str "https://deckofcardsapi.com/api/deck/" (str deck-id) "/shuffle/"))

;;;;;;;;;;;;;;;;;

;; Brand new deck of cards
(defn new-deck-of-cards-api []
  (str "https://deckofcardsapi.com/api/deck/new/"))

;;;;;;;;;;;;;;;;;

;; A Partial Deck:
;; We pass a vector of cards
(defn partial-deck-api []
  (str "https://deckofcardsapi.com/api/deck/new/shuffle/?cards=AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH"))

;;;;;;;;;;;;;;;;;

;;Adding to Piles
(defn [deck-id pile-name cards]
  (str "https://deckofcardsapi.com/api/deck/" deck_id "/pile/" pile_name "/add/?cards=AS,2S"))

;;;;;;;;;;;;;;;;;

;;Shuffle Piles

(defn shuffle-piles-api [deck-id pile-name]
  (str "https://deckofcardsapi.com/api/deck/" deck-id "/pile/" pile-name "/shuffle"))

;;;;;;;;;;;;;;;;;

;;Listing Cards in Piles

(defn list-cards-in-piles-api [deck-id pile-name]
  (str "https://deckofcardsapi.com/api/deck/" deck-id "/pile/" pile-name "/list"))

;;;;;;;;;;;;;;;;;

;;Drawing from Piles

;; https://deckofcardsapi.com/api/deck/<<deck_id>>/pile/<<pile_name>>/draw/?cards=AS
;; https://deckofcardsapi.com/api/deck/<<deck_id>>/pile/<<pile_name>>/draw/?count=2
;; https://deckofcardsapi.com/api/deck/<<deck_id>>/draw/bottom/


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;;;;;;;;;;;;;;;;
;; http-kit
;;;;;;;;;;;;;;;;

(http/get (shuffle-the-cards-api 1))

(let [{:keys [status headers body error] :as resp}
      @(http/get (shuffle-the-cards-api 1))]
  (if error
    (println "Failed, exception: " error)
    (println "HTTP GET success: " status)))

;;;;;;;;;;;;;;;;
;; clj-http
;;;;;;;;;;;;;;;;

(parse-string
 (:body
  (client/get
   (shuffle-the-cards-api 1)
   {:accept :json})))

(def deck-id "vc20c4syoain")

(parse-string
 (:body
  (client/get
   (draw-a-card deck-id 1)
   {:accept :json})))

