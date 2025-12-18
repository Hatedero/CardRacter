package com.retardero.cardracter.app.api
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.Cards
import com.retardero.cardracter.app.model.User
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ExampleCardRacterService {
    @GET("/cards")
    suspend fun getExampleData(): Cards

    @GET("/card/{id}")
    suspend fun getCard(@Path("id") idCard: Int): Card

    @POST("/card")
    suspend fun saveCard(@Path("card") card: Card): Card

    @GET("/user")
    suspend fun getExampleUserData(): User
}