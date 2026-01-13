package com.retardero.cardracter.app.repositories

import android.util.Log
import com.retardero.cardracter.app.api.NetworkDataSource
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.database.DBDataSource
import com.retardero.cardracter.app.model.User
import com.retardero.cardracter.app.model.Users

object UserRepository {
    suspend fun getUser(userId: Int): Resource<User> {
        try {
            val response = DBDataSource.getInstance().userDAO().get(userId)
            println("GET USER -> " + response)
            if(response == null){
                return Resource.Error( "Unknown error")
            }
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("UserRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getUsers(): Resource<List<User>>{
        try {
            val response = DBDataSource.getInstance().userDAO().getAllUsers()
            println("GET USERS -> " + response)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("UserRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun saveUser(user: User): Resource<Long>{
        try {
            /*
            val response = NetworkDataSource.userApiService.saveUser(user)
            */
            val response = DBDataSource.getInstance().userDAO().insert(user)
            println("SAVE USER -> " + response)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }
}