package com.example.test_10.presentation.event.to

sealed class ToAccountEvent {
    class FetchToAccount(var userInput: String, var inputType: String) : ToAccountEvent()
    object ResetErrorMessage : ToAccountEvent()
}