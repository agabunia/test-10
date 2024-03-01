package com.example.test_10.presentation.event.from

sealed class FromAccountEvent {
    object FetchFromAccount: FromAccountEvent()
    object ResetErrorMessage: FromAccountEvent()
}