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
    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun fetchCollections() {
        viewModelScope.launch {
            val response = CardRacterRepository.getUserCollections()

            when(response) {
                is Resource.Success -> {
                    println("SUCESS")
                    var test = listOf<Card.CollectionCard>()
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