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

    suspend fun getCard(id : Int): Resource<Card> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val response = converter.fromIntermediaryCard( DBDataSource.getInstance().cardDAO().get())
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun postCard(card: Card): Boolean {
        try {
            val response = NetworkDataSource.apiService.saveCard(card)
            //DBDataSource.getInstance().cardDAO().insert(card)
            return true
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return false
        }
    }
}