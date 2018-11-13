## A Brand New Deck
curl "https://deckofcardsapi.com/api/deck/new/" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## Draw a Card
curl "https://deckofcardsapi.com/api/deck/8n8c350akmq0/draw/?count=2" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## Adding to Piles
curl "https://deckofcardsapi.com/api/deck/8n8c350akmq0/pile/pile1/add/?cards=AS,2S" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## Drawing from Piles - 1
curl "https://deckofcardsapi.com/api/deck/8n8c350akmq0/pile/pile1/draw/?cards=2S" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## Drawing from Piles - 2
curl "https://deckofcardsapi.com/api/deck/8n8c350akmq0/pile/pile1/draw/?count=1" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## Reshuffle the Cards
curl "https://deckofcardsapi.com/api/deck/8n8c350akmq0/shuffle/" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## A Partial Deck
curl "https://deckofcardsapi.com/api/deck/new/shuffle/?cards=AS,2S,KS,AD" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## Drawing from Piles - 3
curl "https://deckofcardsapi.com/api/deck/8n8c350akmq0/draw/bottom/" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## Shuffle the Cards
curl "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## Shuffle Piles
curl "https://deckofcardsapi.com/api/deck/8n8c350akmq0/pile/pile1/shuffle?cards=2S" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'

## Listing Cards in Piles
curl "https://deckofcardsapi.com/api/deck/c74xqlsnfxd2/pile/pile1/list?cards=AS" \
     -H 'Cookie: __cfduid=dc7e8b1928ddf4a06cb0048d1023f4a6d1541771751'
