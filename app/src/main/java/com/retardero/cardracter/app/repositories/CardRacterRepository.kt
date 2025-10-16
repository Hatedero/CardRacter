package com.retardero.cardracter.app.repositories

import com.retardero.cardracter.app.api.NetworkDataSource
import com.retardero.cardracter.app.model.Card

object CardRacterRepository {

    suspend fun getCards(): Card {
        try {
            val response = NetworkDataSource.apiService.getExampleData()
            return Card.MultiCategoryCard.empty()
            //return response.message()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return Card.MultiCategoryCard.empty()
        //return ""
    }
}