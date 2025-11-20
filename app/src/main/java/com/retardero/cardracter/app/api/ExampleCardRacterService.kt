package com.retardero.cardracter.app.api
import com.retardero.cardracter.app.model.Cards
import com.retardero.cardracter.app.model.Account
import retrofit2.http.GET

interface ExampleCardRacterService {
    @GET("/cards")
    suspend fun getExampleData(): Cards

    @GET("/user")
    suspend fun getExampleUserData(): Account
}