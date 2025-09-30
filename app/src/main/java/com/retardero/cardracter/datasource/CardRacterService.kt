package com.retardero.cardracter.datasource
import com.retardero.cardracter.datasource.model.CharacterCard
import com.retardero.cardracter.datasource.model.CharacterCardList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface CardRacterService {
    @GET("/cards")
    suspend fun getExampleDataList(): Response<CharacterCardList>

    @GET("/cards/{id}")
    suspend fun getExampleData(): Response<CharacterCard>
}