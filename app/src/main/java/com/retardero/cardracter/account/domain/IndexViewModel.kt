package com.retardero.cardracter.homepage.domain

/*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.repositories.CardRacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AccountViewModel: ViewModel() {

    private val characterCardState:MutableStateFlow<Card> = MutableStateFlow<Card>(Card.MultiCategoryCard.CharacterCard.empty())
    val characterCard: StateFlow<Card> = characterCardState.asStateFlow()

    fun fetchCards() {
        viewModelScope.launch {
            val card = CardRacterRepository.getCards()


            characterCardState.value = card ?: CharacterCard.empty()
        }
    }

    private fun sortCard(card: Card): Card {
        return CharacterCard.empty()
    }
}*/