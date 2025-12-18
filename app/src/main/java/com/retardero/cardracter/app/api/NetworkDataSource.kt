package com.retardero.cardracter.app.api

//import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkDataSource {
    private const val BASE_URL = "https://api.magicthegathering.io/v1/"

    /*val intercepter = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }*/
    val client = OkHttpClient.Builder().apply {
        //this.addInterceptor(intercepter)
    }.build()
    
    val apiService: ExampleCardRacterService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExampleCardRacterService::class.java)
    }

    val userApiService: ExampleUserService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExampleUserService::class.java)
    }
}

sealed class Resource<out T> {
    data class Success<out T>(val data: T): Resource<T>()
    data class Error(val error: String): Resource<Nothing>()
}