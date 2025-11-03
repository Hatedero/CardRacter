package com.retardero.cardracter.app.api
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.Cards
import retrofit2.Response
import retrofit2.http.GET

interface ExampleCardRacterService {
    @GET("/cards")
    suspend fun getExampleData(): Cards
}