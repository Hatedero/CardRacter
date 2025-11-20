package com.retardero.cardracter.homepage.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.repositories.CardRacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {

    private val characterCardState:MutableStateFlow<Card> = MutableStateFlow<Card>(Card.MultiCategoryCard.empty())
    val characterCard: StateFlow<Card> = characterCardState.asStateFlow()

    fun fetchCards() {
        viewModelScope.launch {
            val card = CardRacterRepository.getCard(0)


            //characterCardState.value = card ?: Card.MultiCategoryCard.empty()
        }
    }

    private fun sortCard(card: Card): Card {
        return Card.MultiCategoryCard.empty()
    }
}