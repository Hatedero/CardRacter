package com.retardero.cardracter.homepage.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.database.Converters
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.CustomCategory
import com.retardero.cardracter.app.repositories.CardRacterRepository
import com.retardero.cardracter.collections.model.ModifiableCard
import com.retardero.cardracter.collections.model.ModifiableCards
import com.retardero.cardracter.collections.model.ModifiableCustomAttribute
import com.retardero.cardracter.collections.model.ModifiableCustomCategory
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.sql.ResultSet
import kotlin.collections.emptyList
import kotlin.random.Random

class ModifyCardViewModel: ViewModel() {

    private val activeCardState:MutableStateFlow<ModifiableCard> = MutableStateFlow<ModifiableCard>(ModifiableCard.ModifiableMultiCategoryCard.testData())
    val activeCard: StateFlow<ModifiableCard> = activeCardState.asStateFlow()

    var lastAttributeId = 1
    var lastCategoryId = 1

    fun fetchCard(cardId : Int, cardType : Int) {
        viewModelScope.launch {
            println("FETCH CARD")

            val card : Resource<Card> = when (cardId) {
                -1 ->
                    when (cardType) {
                        0 -> Resource.Success(Card.MultiCategoryCard.empty())
                        1 -> Resource.Success(Card.CollectionCard.empty())
                        else -> Resource.Error("NON SUPPORTED CARD TYPE")
                    }

                else -> CardRacterRepository.getCard(cardId)
            }

            val converter = Converters()

            activeCardState.value = converter.toModifiableCard((card as Resource.Success).data) ?: ModifiableCard.ModifiableMultiCategoryCard.testData()
        }
    }

    fun addNewAttribute(categoryId : Int) {
        val newCard = activeCard.value.copy(values = activeCard.value.returnValue<List<ModifiableCustomCategory>>().toMutableList().also { activeCard.value.returnValue<List<ModifiableCustomCategory>>().forEachIndexed { index, category ->
            if (category.id == categoryId)
                when (category) {
                    is ModifiableCustomCategory.ModifiableMultiAttributesCategory -> {
                        it[index] = category.copy(attributes = category.attributes.toMutableList().also { newCategory -> newCategory.add(ModifiableCustomAttribute.ModifiableTextAttribute(lastAttributeId, "", "")) })
                        lastAttributeId++
                    }
                    is ModifiableCustomCategory.ModifiableCardsCategory -> {

                    }
                    is ModifiableCustomCategory.ModifiableSingleAttributeCategory -> {

                    }
                }
        } } )
        activeCardState.value = newCard
        println("ADD CATEGORY")
    }

    fun addNewCategory() {
        val newCard = activeCard.value.copy(values = activeCard.value.returnValue<List<ModifiableCustomCategory>>().toMutableList().also { it.add(ModifiableCustomCategory.ModifiableMultiAttributesCategory(lastCategoryId,"", emptyList()))
        lastCategoryId++} )
        activeCardState.value = newCard
        println("ADD CATEGORY")
    }

    fun updateTitle(new : String) {
        val newCard = activeCard.value.copy(title = new, values = activeCard.value.returnValue<List<ModifiableCustomCategory>>())
        activeCardState.value = newCard
        println("UPDATE TITLE")
    }

    fun updateCategoryTitle(new : String, id : Int) {
        val newCard = activeCard.value.copy(values =
        when (activeCard.value) {
            is ModifiableCard.ModifiableMultiCategoryCard -> {
                (activeCard.value as ModifiableCard.ModifiableMultiCategoryCard).cardAttributes.toMutableList().also { it.forEachIndexed { index, category ->
                    if(category.id == id) {
                        it[index] = it[index].copy(title = new)
                    }
                } }
            }
            is ModifiableCard.ModifiableCollectionCard -> {
                (activeCard.value as ModifiableCard.ModifiableCollectionCard).cardAttribute.copy(title = new)
            }
        })
        activeCardState.value = newCard
        println("UPDATE CATEGORY")
    }

    fun updateAttributeValue(new : String, id : Int) {
        val newCard = activeCard.value.copy(values =
            when (activeCard.value) {
                is ModifiableCard.ModifiableMultiCategoryCard -> {
                    (activeCard.value as ModifiableCard.ModifiableMultiCategoryCard).cardAttributes.toMutableList().also { it.forEachIndexed { index, category ->
                        when (category) {
                            is ModifiableCustomCategory.ModifiableCardsCategory -> {
                            }
                            is ModifiableCustomCategory.ModifiableMultiAttributesCategory -> {
                                category.attributes.forEachIndexed { attributeIndex, attribute ->
                                    if (attribute.id == id)
                                        it[index] = category.copy(attributes = category.attributes.toMutableList().also { ModifiedAttributeList ->
                                            ModifiedAttributeList[attributeIndex] = category.attributes[attributeIndex].copy(value = new)
                                        })
                                }
                            }
                            is ModifiableCustomCategory.ModifiableSingleAttributeCategory -> {
                                if ( category.attribute.id == id) {
                                    it[index] = category.copy(attribute = category.attribute.copy(value = new))
                                }
                            }
                        }
                    } }
                }
                is ModifiableCard.ModifiableCollectionCard -> {
                    (activeCard.value as ModifiableCard.ModifiableCollectionCard).cardAttribute
                }
            })
        activeCardState.value = newCard
        println("UPDATE ATTRIBUTE VALUE")
    }

    fun saveCard() {
        viewModelScope.launch {
            val converter = Converters()
            var tempCard = activeCard.value
            println("SEND CARD " + tempCard)

            when (tempCard) {
                is ModifiableCard.ModifiableMultiCategoryCard -> {
                    tempCard.cardAttributes.forEach { category ->
                        var newCategoryId = CardRacterRepository.getHighestCategoryId()
                        when (newCategoryId) {
                            is Resource.Success -> {
                                category.id = newCategoryId.data + 1
                            }
                            is Resource.Error -> println(newCategoryId.error)
                        }
                        when (category) {
                            is ModifiableCustomCategory.ModifiableMultiAttributesCategory -> {
                                category.attributes.forEach { attribute ->
                                    var newAttributeId = CardRacterRepository.getHighestAttributeId()
                                    when (newAttributeId) {
                                        is Resource.Success -> {
                                            attribute.id = newAttributeId.data + 1
                                        }

                                        is Resource.Error -> println(newAttributeId.error)
                                    }
                                }
                            }
                            is ModifiableCustomCategory.ModifiableCardsCategory -> {
                                category.cards.forEach { attribute ->
                                    var newAttributeId = CardRacterRepository.getHighestAttributeId()
                                    when (newAttributeId) {
                                        is Resource.Success -> {
                                            attribute.id = newAttributeId.data + 1
                                            attribute.attributeId = attribute.id
                                        }

                                        is Resource.Error -> println(newAttributeId.error)
                                    }
                                }
                            }
                            is ModifiableCustomCategory.ModifiableSingleAttributeCategory -> {
                                var newAttributeId = CardRacterRepository.getHighestAttributeId()
                                when (newAttributeId) {
                                    is Resource.Success -> {
                                        category.attribute.id = newAttributeId.data + 1
                                    }
                                    is Resource.Error -> println(newAttributeId.error)
                                }
                            }
                        }
                    }
                    if (tempCard.cardId == -1) {
                        var newId = CardRacterRepository.getHighestCardId()
                        when (newId) {
                            is Resource.Success -> {
                                tempCard.cardId = newId.data + 1
                                tempCard.id = tempCard.cardId
                                activeCardState.value = tempCard
                            }
                            is Resource.Error -> println(newId.error)
                        }
                    }

                    println("CARD ID " + tempCard.id)
                    println("CARD CARDID " + tempCard.cardId)

                    var cardToBeSaved = converter.fromModifiableCard(tempCard)

                    CardRacterRepository.postCard(cardToBeSaved)
                }
                is ModifiableCard.ModifiableCollectionCard -> {

                }
            }
        }
    }
}