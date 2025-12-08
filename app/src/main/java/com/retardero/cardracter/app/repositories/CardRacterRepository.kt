package com.retardero.cardracter.app.repositories

import android.util.Log
import androidx.room.RoomDatabase
import com.retardero.cardracter.app.api.NetworkDataSource
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.database.Converters
import com.retardero.cardracter.app.database.DBDataSource
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.Cards

object CardRacterRepository {

    /*suspend fun getCards(): Resource<List<Card>> {
        try {
            //val response = NetworkDataSource.apiService.getExampleData()
            val response = Cards(DBDataSource.getInstance().cardDAO().getAll())
            return Resource.Success(response.cardList)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }*/

    suspend fun getCard(cardId : Int): Resource<Card> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val response = converter.fromIntermediaryCard( DBDataSource.getInstance().cardDAO().get(cardId))
            println("RETURN CARD -> " + response)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getAllMultiCategoryCards(): Resource<List<Card.MultiCategoryCard>> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val initialResponse = DBDataSource.getInstance().cardDAO().getAllMultiCategoryCards()
            var response = listOf<Card.MultiCategoryCard>()
            initialResponse.forEach { card ->
                response = response.plus( converter.fromIntermediaryCard(card) as Card.MultiCategoryCard )
            }
            println("RETURN CARD -> " + response)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getHighestCardId(): Resource<Int> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val response = DBDataSource.getInstance().cardDAO().getHighestCardId()
            println("RETURN HIGHEST CARD ID -> " + response)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getUserCollections(): Resource<List<Card.CollectionCard>> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val initialResponse = DBDataSource.getInstance().cardDAO().getAllUserCollections()
            var response = listOf<Card.CollectionCard>()
            initialResponse.forEach { card ->
                response = response.plus( converter.fromIntermediaryCard(card) as Card.CollectionCard )
            }
            println("RETURN COLLECTION CARDS -> " + response)
            return Resource.Success(emptyList())
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun postCard(card: Card): Boolean {
        try {
            //val response = NetworkDataSource.apiService.saveCard(card)
            val converter = Converters()
            DBDataSource.getInstance().cardDAO().insert(converter.toIntermediaryCard(card))
            return true
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return false
        }
    }
}