package com.retardero.cardracter.app.repositories

import android.util.Log
import androidx.room.RoomDatabase
import com.retardero.cardracter.app.api.NetworkDataSource
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.database.Converters
import com.retardero.cardracter.app.database.DBDataSource
import com.retardero.cardracter.app.database.intermediary.AttributeType
import com.retardero.cardracter.app.database.intermediary.CategoryType
import com.retardero.cardracter.app.database.intermediary.IntermediaryAttribute
import com.retardero.cardracter.app.database.intermediary.IntermediaryCategory
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.Cards
import com.retardero.cardracter.app.model.CustomAttribute
import com.retardero.cardracter.app.model.CustomCategory

object CardRacterRepository {

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

    suspend fun getCategoriesWithAttributesFromCardId(cardId: Int): Resource<List<CustomCategory>> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val DBresponse = DBDataSource.getInstance().categoryDAO().getAllCategoriesFromCard(cardId)
            var response = listOf<CustomCategory>()

            DBresponse.forEach { category ->
                var attributes = listOf<CustomAttribute>()
                var callAttributes = getAttributesFromCategoryId(category.categoryId)
                when (callAttributes) {
                    is Resource.Success -> attributes = callAttributes.data
                    is Resource.Error -> println("ERREUR LORS DE LA RECUPERATION D'ATTRIBUTS")
                }
                response = response.plus(converter.fromIntermediaryCategory(category).copy(attributes = attributes))
            }

            println("RETURN CATEGORY -> " + response)
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getAttributesFromCategoryId(cardId: Int): Resource<List<CustomAttribute>> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val DBresponse = DBDataSource.getInstance().attributeDAO().getAllAttributesFromCategory(cardId)
            var response = listOf<CustomAttribute>()

            DBresponse.forEach { attribute ->
                response = response.plus(converter.fromIntermediaryAttribute(attribute))
            }

            println("RETURN ATTRIBUTE -> " + response)
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
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getHighestCategoryId(): Resource<Int> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val response = DBDataSource.getInstance().categoryDAO().getHighestCategoryId()
            return Resource.Success(response)
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return Resource.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun getHighestAttributeId(): Resource<Int> {
        try {
            //val response = NetworkDataSource.apiService.getCard(id)
            val converter = Converters()

            val response = DBDataSource.getInstance().attributeDAO().getHighestAttributeId()
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
            when (card) {
                is Card.MultiCategoryCard -> {
                    card.cardAttributes.forEach { category ->
                        DBDataSource.getInstance().categoryDAO().insertCategory(converter.toIntermediaryCategory(category).copy(cardId = card.cardId))

                        when (category) {
                            is CustomCategory.MultiAttributesCategory -> {
                                category.attributes.forEach { attribute ->
                                    DBDataSource.getInstance().attributeDAO().insertAttribute(converter.toIntermediaryAttribute(attribute).copy(categoryId = category.categoryId))
                                }
                            }

                            is CustomCategory.SingleAttributeCategory -> {
                                DBDataSource.getInstance().attributeDAO().insertAttribute(converter.toIntermediaryAttribute(category.attribute).copy(categoryId = category.categoryId))
                            }

                            is CustomCategory.CardsCategory -> {
                                category.cards.forEach { attribute ->
                                    DBDataSource.getInstance().attributeDAO().insertAttribute(converter.toIntermediaryAttribute(attribute).copy(categoryId = category.categoryId))
                                }
                            }
                        }
                    }
                }

                is Card.CollectionCard -> {
                    DBDataSource.getInstance().categoryDAO().insertCategory(converter.toIntermediaryCategory(card.cardAttributes).copy(categoryId = card.cardId))
                    card.cardAttributes.cards.forEach { attribute ->
                        DBDataSource.getInstance().attributeDAO().insertAttribute(converter.toIntermediaryAttribute(attribute).copy(categoryId = card.cardAttributes.categoryId))
                    }
                }
            }
            return true
        } catch (e: Exception) {
            Log.e("CardracterRepository", e.message ?: "Unknown error")
            return false
        }
    }
}