package com.example.test_10.data.model.from

import com.squareup.moshi.Json

data class FromAccountDto(
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
    @Json(name = "balance")
    val balance: Int,
    @Json(name = "card_logo")
    val cardLogo: String?
)
