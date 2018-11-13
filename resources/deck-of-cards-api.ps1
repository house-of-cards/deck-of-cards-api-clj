#https://www.twilio.com/docs/usage/tutorials/how-to-make-http-basic-request-twilio-powershell

##########

Invoke-RestMethod -Method Get https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1 

#remaining shuffled success deck_id
#--------- -------- ------- -------
#       52     True    True 9n5ye8h2putj

##########

$var =  Invoke-RestMethod -Method Get https://deckofcardsapi.com/api/deck/9n5ye8h2putj/draw/?count=2
