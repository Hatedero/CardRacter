package com.retardero.cardracter.homepage.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.CustomAttribute
import com.retardero.cardracter.app.model.CustomCategory
import com.retardero.cardracter.app.repositories.CardRacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.AttributedCharacterIterator.Attribute

class CardDetailViewModel: ViewModel() {

    private val characterCardState:MutableStateFlow<Card> = MutableStateFlow<Card>(Card.MultiCategoryCard.empty())
    val characterCard: StateFlow<Card> = characterCardState.asStateFlow()

    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun fetchCard(cardId : Int) {
        viewModelScope.launch {
            println("FETCH CARD")

            val response : Resource<Card> = CardRacterRepository.getCard(cardId)

            when(response) {
                is Resource.Success -> {
                    println("SUCESS")
                        var tempCard = response.data
                        when (tempCard) {
                            is Card.MultiCategoryCard -> {
                                characterCardState.value = tempCard
                                fetchCategoriesWithAttributes(cardId)
                            }
                            is Card.CollectionCard -> {
                                println("WRONG KIND OF CARD")
                            }
                    }
                }
                is Resource.Error -> {
                    println("ERROR")
                    _error.value = response.error
                }
            }
        }
    }

    suspend fun fetchCategoriesWithAttributes(cardId : Int) {
        var categories = emptyList<CustomCategory>()
        viewModelScope.launch {
            println("FETCH CATEGORIES FOR " + cardId)

            val response : Resource<List<CustomCategory>> = CardRacterRepository.getCategoriesWithAttributesFromCardId(cardId)

            when(response) {
                is Resource.Success -> {
                    println("SUCESS")
                    var card = characterCardState.value
                    when (card) {
                        is Card.MultiCategoryCard -> {
                            characterCardState.value = card.copy(cardAttributes = response.data)
                        }

                        is Card.CollectionCard -> {
                            characterCardState.value = card.copy(cardAttributes = response.data.first() as CustomCategory.CardsCategory)
                        }
                    }
                }
                is Resource.Error -> {
                    println("ERROR")
                    _error.value = response.error
                }
            }
        }
    }
}