package com.retardero.cardracter.homepage.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.repositories.CardRacterRepository
import com.retardero.cardracter.collections.model.ModifiableCard
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ModifyCardViewModel: ViewModel() {

    private val activeCardState:MutableStateFlow<ModifiableCard> = MutableStateFlow<ModifiableCard>(ModifiableCard.ModifiableMultiCategoryCard.testData())
    val activeCard: StateFlow<ModifiableCard> = activeCardState.asStateFlow()

    fun fetchCards() {
        viewModelScope.launch {
            val card = CardRacterRepository.getCards()


            //characterCardState.value = card ?: Card.MultiCategoryCard.empty()
        }
    }

    fun updateTitle() {

        val c = activeCard.value
        c.title = "toto"
        viewModelScope.launch {
            activeCardState.emit(c)
        }
        println("UPDATE TITLE")
    }

    private fun sortCard(card: Card): Card {
        return Card.MultiCategoryCard.empty()
    }
}