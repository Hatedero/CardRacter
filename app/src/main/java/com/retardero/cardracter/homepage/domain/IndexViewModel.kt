package com.retardero.cardracter.homepage.domain

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.repositories.CardRacterRepository
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

    fun fetchCards() {
        viewModelScope.launch {
            val response = CardRacterRepository.getCard(0)

            when(response) {
                is Resource.Success -> {
                    var test = listOf<Card>(response.data)
                    cardsState.value =  test
                }
                is Resource.Error -> {
                    _error.value = response.error
                }
            }

            cardsState.value = listOf() ?: emptyList()

            cardsState.value = sortCard(cardsState.value)
        }
    }

    private fun sortCard(cards: List<Card>): List<Card> {
        return emptyList()
    }
}