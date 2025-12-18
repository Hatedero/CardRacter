package com.retardero.cardracter.app.repositories

import android.util.Log
import com.retardero.cardracter.app.api.NetworkDataSource
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.database.DBDataSource
import com.retardero.cardracter.app.model.User
import com.retardero.cardracter.app.model.Users

object UserRepository {
    suspend fun getUser(): Resource<User> {
        try {
            /*
            val response = DBDataSource.getInstance().userDAO().get()
            return Resource.Success(response)
            */
        } catch (e: Exception) {
            try{
                val response = NetworkDataSource.userApiService.getExampleUserData()
            }catch{

            }
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getUsers(): Resource<Users>{
        try {
            val response = NetworkDataSource.userApiService.getExampleUsers()
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getUser(userId: Int): Resource<User>{
        try {
            val response = NetworkDataSource.userApiService.getUser(userId)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun saveUser(user: User): Resource<User>{
        try {
            val response = NetworkDataSource.userApiService.saveUser(user)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }
}