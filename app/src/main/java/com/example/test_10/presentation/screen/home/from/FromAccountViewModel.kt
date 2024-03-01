package com.example.test_10.presentation.screen.home.from

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_10.data.common.Resource
import com.example.test_10.domain.usecase.from.GetFromAccountsUseCase
import com.example.test_10.presentation.event.from.FromAccountEvent
import com.example.test_10.presentation.mapper.from.toPresenter
import com.example.test_10.presentation.state.from.FromAccountState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FromAccountViewModel @Inject constructor(
    private val getFromAccountsUseCase: GetFromAccountsUseCase
) : ViewModel() {

    private val _fromAccountState = MutableStateFlow(FromAccountState())
    val fromAccountState: SharedFlow<FromAccountState> = _fromAccountState.asStateFlow()

    fun onEvent(event: FromAccountEvent) {
        when(event) {
            is FromAccountEvent.FetchFromAccount -> fetchFromAccounts()
            is FromAccountEvent.ResetErrorMessage -> errorMessage(message = null)
        }
    }


    private fun fetchFromAccounts() {
        viewModelScope.launch {
            getFromAccountsUseCase().collect {
                when (it) {
                    is Resource.Success -> {
                        _fromAccountState.update { currentState ->
                            currentState.copy(fromAccountList = it.data.map {
                                it.toPresenter()
                            })
                        }
                    }

                    is Resource.Error -> {
                        errorMessage(message = it.errorMessage)
                    }

                    is Resource.Loading -> {
                        _fromAccountState.update { currentState -> currentState.copy(isLoading = it.loading) }
                    }
                }
            }
        }
    }

    private fun errorMessage(message: String?) {
        _fromAccountState.update { currentState -> currentState.copy(errorMessage = message) }
    }

}
