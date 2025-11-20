package com.retardero.cardracter.homepage.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.model.Account
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

private val _error: MutableStateFlow<String?> = MutableStateFlow(null)

class AccountViewModel: ViewModel() {

    private val accountState:MutableStateFlow<Account> = MutableStateFlow(Account.empty())
    val activeAccount: StateFlow<Account> = accountState.asStateFlow()

    fun fetchAccount() {
        viewModelScope.launch {
            val acco = UserRepository.getUser()
            when(acco){
                is Resource.Success -> {
                    accountState.value = acco.data
                }
                is Resource.Error -> {
                    _error.value = acco.error
                }
            }
            //userState.value = acco ?: user.empty()
        }
    }

    fun updateName(new : String) {
        val a = activeAccount.value.copy(name = new)
        accountState.value = a
        println("UPDATE NAME")
    }

    fun updateEmail(new : String) {
        val a = activeAccount.value.copy(mail = new)
        accountState.value = a
        println("UPDATE EMAIL")
    }

    fun updateDateOfBirth(new : LocalDate){
        val a = activeAccount.value.copy(dateOfBirth = new)
        accountState.value = a
        println("UPDATE EMAIL")
    }
}