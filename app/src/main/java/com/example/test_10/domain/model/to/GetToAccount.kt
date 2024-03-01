package com.example.test_10.domain.model.to

data class GetToAccount(
    val id: Int,
    val accountName: String,
    val accountNumber: String,
    val currencyType: String,
    val cardType: String,
    val cardLogo: String?
)