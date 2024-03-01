package com.example.test_10.presentation.model.from

data class FromAccount(
    val id: Int,
    val accountName: String,
    val accountNumber: String,
    val currencyType: String,
    val cardType: String,
    val balance: Int,
    val cardLogo: String?
)
