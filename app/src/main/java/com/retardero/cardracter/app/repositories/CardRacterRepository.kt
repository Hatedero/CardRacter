package com.retardero.cardracter.app.repositories

import android.util.Log
import com.retardero.cardracter.app.api.NetworkDataSource
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.model.Card

object CardRacterRepository {

    suspend fun getCards(): Resource<List<Card>> {
        try {
            val response = NetworkDataSource.apiService.getExampleData()
            return Resource.Success(response.cardList)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }
}