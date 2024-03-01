package com.example.test_10.presentation.state.from

import com.example.test_10.presentation.model.from.FromAccount

data class FromAccountState(
    val fromAccountList: List<FromAccount>? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false
)
