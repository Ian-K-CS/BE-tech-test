package com.ian.techtest.Service

object CSCardsRequest {

}
//  1. Get the obj/details we have of the user making the request to this server
//  2. Serialise the scala object we want to send to Partner 1 - CSCards
//  3. Make the request to Partner 1 - CSCards with Json object
//  4. Get response back from Partner 1 - CSCards and deserialise json response to scala obj
//  5. To test - send this new scala obj with all the card details from Partner 1 - CSCards to the user,
//     no eligability filtering or anything, just return everything.