package com.retardero.cardracter.app.repositories

import com.retardero.cardracter.app.model.card.Card
import com.retardero.cardracter.app.model.card.CharacterCard
import com.retardero.cardracter.app.api.NetworkDataSource

object CardRacterRepository {

    suspend fun getCards(): Card {
        try {
            val response = NetworkDataSource.apiService.getExampleData()
            return CharacterCard.empty()
            //return response.message()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return CharacterCard.empty()
        //return ""
    }
}