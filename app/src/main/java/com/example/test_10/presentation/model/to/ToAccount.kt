package com.example.test_10.presentation.model.to

data class ToAccount(
    val id: Int,
    val accountName: String,
    val accountNumber: String,
    val currencyType: String,
    val cardType: String,
    val cardLogo: String?
)
