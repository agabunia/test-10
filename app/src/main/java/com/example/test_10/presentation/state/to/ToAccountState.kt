package com.example.test_10.presentation.state.to

import com.example.test_10.presentation.model.from.FromAccount
import com.example.test_10.presentation.model.to.ToAccount

data class ToAccountState(
    val toAccount: ToAccount? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false
)
