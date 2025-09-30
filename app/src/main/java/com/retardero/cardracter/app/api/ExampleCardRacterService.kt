package com.retardero.cardracter.app.api
import com.retardero.cardracter.datasource.model.CharacterCard
import com.retardero.cardracter.datasource.model.ExampleCharacterCardList
import retrofit2.Response
import retrofit2.http.GET

interface ExampleCardRacterService {
    @GET("/cards")
    suspend fun getExampleDataList(): Response<ExampleCharacterCardList>

    @GET("/cards/{id}")
    suspend fun getExampleData(): Response<CharacterCard>
}