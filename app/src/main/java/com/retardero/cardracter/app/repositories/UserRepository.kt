package com.retardero.cardracter.app.repositories

import android.util.Log
import com.retardero.cardracter.app.api.NetworkDataSource
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.database.Converters
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
            Log.e("UserRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getHighestUserId(): Resource<Int> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val response = DBDataSource.getInstance().userDAO().getHighestUserId()
            println("RETURN HIGHEST USER ID -> " + response)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("UserRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun updateUser(user : User): Resource<Int> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val response = DBDataSource.getInstance().userDAO().updateUser(user)
            println("UPDATED USER ID -> " + user)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("UserRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }
}