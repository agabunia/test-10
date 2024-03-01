package com.example.test_10.presentation.screen.home.to

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_10.data.common.Resource
import com.example.test_10.domain.usecase.to.AccountNumberValidatorUseCase
import com.example.test_10.domain.usecase.to.CustomerIdValidatorUseCase
import com.example.test_10.domain.usecase.to.GetToAccountUseCase
import com.example.test_10.domain.usecase.to.PhoneValidatorUseCase
import com.example.test_10.presentation.event.to.ToAccountEvent
import com.example.test_10.presentation.mapper.to.toPresenter
import com.example.test_10.presentation.state.to.ToAccountState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToAccountViewModel @Inject constructor(
    private val getToAccountUseCase: GetToAccountUseCase,
    private val accountNumberValidatorUseCase: AccountNumberValidatorUseCase,
    private val customerIdValidatorUseCase: CustomerIdValidatorUseCase,
    private val phoneValidatorUseCase: PhoneValidatorUseCase
) : ViewModel() {

    private val _toAccountState = MutableStateFlow(ToAccountState())
    val toAccountState: SharedFlow<ToAccountState> = _toAccountState.asStateFlow()

    fun onEvent(event: ToAccountEvent) {
        when (event) {
            is ToAccountEvent.FetchToAccount -> userOutcome(event.userInput, event.inputType)

            is ToAccountEvent.ResetErrorMessage -> errorMessage(message = null)
        }
    }

    private fun fetchToAccount() {
        viewModelScope.launch {
            getToAccountUseCase().collect {
                when (it) {
                    is Resource.Success -> {
                        _toAccountState.update { currentState ->
                            currentState.copy(toAccount = it.data.toPresenter())
                        }
                    }

                    is Resource.Error -> {
                        errorMessage(message = it.errorMessage)
                    }

                    is Resource.Loading -> {
                        _toAccountState.update { currentState -> currentState.copy(isLoading = it.loading) }
                    }
                }
            }
        }
    }

    private fun checkInput(userInput: String, inputType: String): Boolean {
        fetchToAccount()

        var isCorrect = false

        if (inputType == "Account Number") {
            _toAccountState.value.toAccount?.let {
                isCorrect = accountNumberValidatorUseCase(userInput, it.accountNumber)
            }
        }
        if (inputType == "Customer ID") {
            isCorrect = customerIdValidatorUseCase(userInput)
        }
        if (inputType == "Mobile Phone") {
            isCorrect = phoneValidatorUseCase(userInput)
        }

        return isCorrect
    }

    private fun userOutcome(userInput: String, inputType: String) {
        if (checkInput(userInput = userInput, inputType = inputType)) {
            fetchToAccount()
        } else {
            _toAccountState.update { currentState -> currentState.copy(errorMessage = "Incorrect data") }
        }
    }


    private fun errorMessage(message: String?) {
        _toAccountState.update { currentState -> currentState.copy(errorMessage = message) }
    }

}