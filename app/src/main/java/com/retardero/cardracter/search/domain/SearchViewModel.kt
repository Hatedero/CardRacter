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
    private val historyState:MutableStateFlow<List<String>> = MutableStateFlow<List<String>>(emptyList<String>())
    val history: StateFlow<List<String>> = historyState.asStateFlow()

    private val tagsState:MutableStateFlow<List<String>> = MutableStateFlow<List<String>>(emptyList<String>())
    val tags: StateFlow<List<String>> = tagsState.asStateFlow()

    fun checkHistory(){
        historyState.value = historyState.value.stream().distinct().toList()
    }

    fun checkTags(){
        tagsState.value = tagsState.value.stream().distinct().toList()
    }

    fun fetchHistory() {
        viewModelScope.launch {
            historyState.value = listOf<String>("Lumos",
                "Rudeus Graycat",
                "Gragas",
                "Corto Faury",
                "Frimousse la grimousse",
                "William Hunter",
                "William Hunter Junior",
                "Constance Ward")
            checkHistory()
        }
    }

    fun fetchTags() {
        viewModelScope.launch {
            tagsState.value = listOf<String>("Rouge",
                "Orc",
                "NSFW",
                "Corto Faury",
                "Pieds",
                "Food || rat",
                "Dark Tales",
                "New born",
                "Contrées du Lointain",
                "Aman Emuil")
            checkTags()
        }
    }
}