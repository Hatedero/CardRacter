package com.retardero.cardracter.homepage.domain

import android.content.res.Resources
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.database.Converters
import com.retardero.cardracter.app.database.intermediary.IntermediaryCard
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.repositories.CardRacterRepository
import com.retardero.cardracter.collections.model.ModifiableCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class IndexViewModel: ViewModel() {

    private val cardsState:MutableStateFlow<List<Card>> = MutableStateFlow(
        emptyList())
    val cards: StateFlow<List<Card>> = cardsState.asStateFlow()
    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val cardState:MutableStateFlow<Card.MultiCategoryCard> = MutableStateFlow(
        Card.MultiCategoryCard.empty())
    val card: StateFlow<Card.MultiCategoryCard> = cardState.asStateFlow()

    fun fetchCards() {
        viewModelScope.launch {
            val response = CardRacterRepository.getAllMultiCategoryCards()

            when(response) {
                is Resource.Success -> {
                    println("SUCESS")
                    cardsState.value =  response.data
                }
                is Resource.Error -> {
                    println("ERROR")
                    _error.value = response.error
                }
            }
        }
    }

    fun fetchCard(cardId : Int) {
        viewModelScope.launch {
            println("FETCH CARD")

            val response : Resource<Card> = CardRacterRepository.getCard(cardId)

            when(response) {
                is Resource.Success -> {
                    println("SUCESS")
                    if (response.data is Card.MultiCategoryCard) //ATTENTION ! CAST SÛR, MAIS NECESSAIRE ?
                        cardState.value =  response.data
                    else println("ERROR")
                }
                is Resource.Error -> {
                    println("ERROR")
                    _error.value = response.error
                }
            }
        }
    }
}