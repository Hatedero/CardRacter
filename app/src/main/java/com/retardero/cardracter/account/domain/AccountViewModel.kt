package com.retardero.cardracter.homepage.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.model.User
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

private val _error: MutableStateFlow<String?> = MutableStateFlow(null)

class AccountViewModel: ViewModel() {

    private val userState:MutableStateFlow<User> = MutableStateFlow(User.empty())
    val activeUser: StateFlow<User> = userState.asStateFlow()

    fun fetchAccount(userId : Int) {
        viewModelScope.launch {
            val acco = UserRepository.getUser(userId)
            when(acco){
                is Resource.Success -> {
                    userState.value = acco.data
                }
                is Resource.Error -> {
                    _error.value = acco.error
                }
            }
            //userState.value = acco ?: user.empty()
        }
    }

    fun updateName(new : String) {
        val a = activeUser.value.copy(name = new)
        userState.value = a
        println("UPDATE NAME")
    }

    fun updateEmail(new : String) {
        val a = activeUser.value.copy(mail = new)
        userState.value = a
        println("UPDATE EMAIL")
    }

    fun updateDateOfBirth(new : LocalDate){
        val a = activeUser.value.copy(dateOfBirth = new)
        userState.value = a
        println("UPDATE EMAIL")
    }
}