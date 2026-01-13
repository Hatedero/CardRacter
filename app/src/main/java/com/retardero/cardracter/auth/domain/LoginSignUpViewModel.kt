package com.retardero.cardracter.homepage.domain

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardero.cardracter.app.api.Resource
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.model.User
import com.retardero.cardracter.app.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class LoginSignUpViewModel: ViewModel() {

    private val userState:MutableStateFlow<User> = MutableStateFlow(User.empty())
    val activeUser: StateFlow<User> = userState.asStateFlow()
    private val _isFormValid = MutableStateFlow(true)
    val isFormValid: StateFlow<Boolean> = _isFormValid.asStateFlow()
    private val dateOfBirthIsSetState =  MutableStateFlow(false)
    fun updateName(new : String) {
        Log.d("user",new)
        val a = activeUser.value.copy(name = new)
        userState.value = a
        println("UPDATE NAME")
        _isFormValid.value = true
    }

    fun updateEmail(new : String) {
        Log.d("user",new)
        val a = activeUser.value.copy(mail = new)
        userState.value = a
        println("UPDATE EMAIL")
        _isFormValid.value = true
    }

    fun updateDateOfBirth(new : LocalDate){
        Log.d("user",new.toString())
        val a = activeUser.value.copy(dateOfBirth = new)
        userState.value = a
        println("UPDATE DATE OF BIRTH")
        _isFormValid.value = true
        dateOfBirthIsSetState.value = true
    }

    fun signUpUser(onSuccess: () -> Unit) {
        val defaultUser = User.empty()
        val user = activeUser.value

        // Validation Logic
        val isValid = user.name.isNotBlank() && user.name!=defaultUser.name &&
                user.mail.isNotBlank() && user.mail!=defaultUser.mail &&
                user.dateOfBirth != LocalDate.now() && dateOfBirthIsSetState.value
        Log.d("user",isValid.toString())
        Log.d("user ",user.name)
        Log.d("user ",user.mail)
        Log.d("user ",user.dateOfBirth.toString())


        if (isValid) {
            _isFormValid.value = true
            viewModelScope.launch {
                val userId = UserRepository.getHighestUserId()

                if (userId is Resource.Success) {
                    var newUser = user.copy(dateJoined = LocalDate.now(), id = userId.data + 1)
                    val result = UserRepository.saveUser(newUser)
                    if (result is Resource.Success) {
                        onSuccess() // Navigate only after successful save
                    }
                }
            }
        } else {
            _isFormValid.value = false // This will trigger the red button
        }
    }
}