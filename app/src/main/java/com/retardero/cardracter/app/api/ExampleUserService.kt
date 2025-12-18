package com.retardero.cardracter.app.api
import com.retardero.cardracter.app.model.User
import com.retardero.cardracter.app.model.Users
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ExampleUserService {
    @GET("/users")
    suspend fun getExampleUsers(): Users

    @GET("/user/{id}")
    suspend fun getUser(@Path("id") userId: Int): User

    @POST("/user")
    suspend fun saveUser(@Path("user") user: User): User

    @GET("/user")
    suspend fun getExampleUserData(): User
}