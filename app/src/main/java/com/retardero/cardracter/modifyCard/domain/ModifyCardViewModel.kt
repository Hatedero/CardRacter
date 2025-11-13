package com.retardero.cardracter.homepage.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.CustomCategory
import com.retardero.cardracter.app.repositories.CardRacterRepository
import com.retardero.cardracter.collections.model.ModifiableCard
import com.retardero.cardracter.collections.model.ModifiableCustomCategory
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class ModifyCardViewModel: ViewModel() {

    private val activeCardState:MutableStateFlow<ModifiableCard> = MutableStateFlow<ModifiableCard>(ModifiableCard.ModifiableMultiCategoryCard.testData())
    val activeCard: StateFlow<ModifiableCard> = activeCardState.asStateFlow()

    fun fetchCards() {
        viewModelScope.launch {
            val card = CardRacterRepository.getCards()

            //characterCardState.value = card ?: Card.MultiCategoryCard.empty()
        }
    }

    fun updateTitle(new : String) {
        val c = activeCard.value.copy(title = new, values = activeCard.value.returnValue<List<ModifiableCustomCategory>>())
        activeCardState.value = c
        println("UPDATE TITLE")
    }

    fun updateCategoryTitle(new : String, id : Int) {
        val c = activeCard.value.copy(values =
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
        activeCardState.value = c
        println("UPDATE CATEGORY")
    }

    /*fun updateTitle(new : String) {
        val c = activeCard.value.copy(title = new, values = activeCard.value.returnValue<List<ModifiableCustomCategory>>())
        activeCardState.value = c
        println("UPDATE TITLE")
    }*/

    private fun sortCard(card: Card): Card {
        return Card.MultiCategoryCard.empty()
    }
}