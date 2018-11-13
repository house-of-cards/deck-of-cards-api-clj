;; NOTE: This namespace covers the following api https://deckofcardsapi.com/

(ns deck-of-cards-api-clj.data
  (:require [org.httpkit.client :as http]
            [clj-http.client :as client]
            [cheshire.core :refer :all]))

;;;;;;;;;;;;;;;;
;; clj-http
;;;;;;;;;;;;;;;;


(defn client-get [api-fxn]
  (parse-string
   (:body
    (client/get
     api-fxn
     {:accept :json}))))

;;;;;;;;;;;;;;;;
;; deck-of-cards-api
;;;;;;;;;;;;;;;;

;; TODO:
;; The value, one of A (for an ace), 2, 3, 4, 5, 6, 7, 8, 9, 0 (for a ten), J (jack), Q (queen), or K (king);
;; The suit, one of S (Spades), D (Diamonds), C (Clubs), or H (Hearts).



;; TODO: default value is 1
(defn shuffle-the-cards-api [deck-count]
  (str "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=" (str deck-count)))

(client-get
 (shuffle-the-cards-api 1))

;;;;;;;;;;;;;;;;;


;; NOTE: replace <<deck_id>> with "new" to create a shuffled deck and draw cards from that deck in the same request.
(defn draw-a-card-api [deck-id card-count]
  (str "https://deckofcardsapi.com/api/deck/" (str deck-id) "/draw/?count=" (str card-count)))

(let [deck-id "drxd0vwf5mc6"]
  (client-get
   (draw-a-card-api deck-id 1)))

;;;;;;;;;;;;;;;;;

;; Reshuffle the Cards:

(defn reshuffle-the-cards-api [deck-id]
  (str "https://deckofcardsapi.com/api/deck/" (str deck-id) "/shuffle/"))

(let [deck-id "drxd0vwf5mc6"]
  (client-get
   (reshuffle-the-cards-api deck-id)))

;;;;;;;;;;;;;;;;;

;; Brand new deck of cards
(defn new-deck-of-cards-api []
  (str "https://deckofcardsapi.com/api/deck/new/"))

(client-get
 (new-deck-of-cards-api ))

;;;;;;;;;;;;;;;;;

;; A Partial Deck:
;; TODO: We pass a vector of cards as arguments
(defn partial-deck-api []
  (str "https://deckofcardsapi.com/api/deck/new/shuffle/?cards=AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH"))

(client-get
 (partial-deck-api ))



;;;;;;;;;;;;;;;;;

;;Adding to Piles
;; TODO: pass the card names as arguments
(defn adding-to-piles-api [deck-id pile-name #_cards]
  (str "https://deckofcardsapi.com/api/deck/" deck-id "/pile/" pile-name "/add/?cards=AS,2S"))


(let [deck-id "drxd0vwf5mc6"]
(client-get
 (adding-to-piles-api deck-id "pile1")))





;;;;;;;;;;;;;;;;;

;;Shuffle Piles

(defn shuffle-piles-api [deck-id pile-name]
  (str "https://deckofcardsapi.com/api/deck/" deck-id "/pile/" pile-name "/shuffle"))

(let [deck-id "drxd0vwf5mc6"]
  (client-get
   (shuffle-piles-api deck-id "pile1")))



;;;;;;;;;;;;;;;;;

;;Listing Cards in Piles

(defn list-cards-in-piles-api [deck-id pile-name]
  (str "https://deckofcardsapi.com/api/deck/" deck-id "/pile/" pile-name "/list"))

(let [deck-id "drxd0vwf5mc6"]
  (client-get
   (shuffle-piles-api deck-id "pile1")))


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

