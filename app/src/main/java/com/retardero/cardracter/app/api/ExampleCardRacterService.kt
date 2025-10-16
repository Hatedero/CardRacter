package com.retardero.cardracter.app.api
import com.retardero.cardracter.app.model.Card
import retrofit2.Response
import retrofit2.http.GET

interface ExampleCardRacterService {
    /*@GET("/cards")
    suspend fun getExampleDataList(): Response<ExampleCharacterCardList>*/

    @GET("/cards/{id}")
    suspend fun getExampleData(): Response<Card.MultiCategoryCard.CharacterCard>
}