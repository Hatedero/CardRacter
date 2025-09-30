package com.retardero.cardracter.datasource.networkdatasource

import com.retardero.cardracter.datasource.CardRacterService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.getValue

object networkdatasource {
    private const val BASE_URL = "https:://NMF.com"

    val apiService: CardRacterService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CardRacterService::class.java)
    }


}