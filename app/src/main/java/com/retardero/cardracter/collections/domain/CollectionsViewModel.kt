package com.retardero.cardracter.homepage.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.repositories.CardRacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CollectionsViewModel: ViewModel() {

    private val collectionsState:MutableStateFlow<List<Card.CollectionCard>> = MutableStateFlow<List<Card.CollectionCard>>(
        emptyList())
    val collections: StateFlow<List<Card.CollectionCard>> = collectionsState.asStateFlow()

    fun fetchCollections() {
        viewModelScope.launch {
            val response = CardRacterRepository.getUserCollections(0)

            when(response) {
                is Resource.Success -> {
                    println("SUCESS")
                    var test = listOf<Card.CollectionCard>(response.data)
                    collectionsState.value =  test
                }
                is Resource.Error -> {
                    println("ERROR")
                    _error.value = response.error
                }
            }
        }
    }
}