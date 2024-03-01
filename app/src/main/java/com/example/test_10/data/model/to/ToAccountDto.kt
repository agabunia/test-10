package com.example.test_10.data.model.to

import com.squareup.moshi.Json

data class ToAccountDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "account_name")
    val accountName: String,
    @Json(name = "account_number")
    val accountNumber: String,
    @Json(name = "valute_type")
    val currencyType: String,
    @Json(name = "card_type")
    val cardType: String,
    @Json(name = "card_logo")
    val cardLogo: String?
)
