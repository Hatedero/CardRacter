package com.retardero.cardracter.app.repositories

import android.util.Log
import com.retardero.cardracter.app.api.NetworkDataSource
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.model.Account

object UserRepository {
    suspend fun getUser(): Resource<Account> {
        try {
            val response = NetworkDataSource.apiService.getExampleUserData()
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }
}