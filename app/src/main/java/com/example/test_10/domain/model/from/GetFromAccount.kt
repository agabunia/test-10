package com.example.test_10.domain.model.from

data class GetFromAccount(
    val id: Int,
    val accountName: String,
    val accountNumber: String,
    val currencyType: String,
    val cardType: String,
    val balance: Int,
    val cardLogo: String?
)
