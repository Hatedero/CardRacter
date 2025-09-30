package com.retardero.cardracter.datasource
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface CardRacterService {
    @GET("/character")
    fun getExampleData(): Call<ExampleResponse>
}