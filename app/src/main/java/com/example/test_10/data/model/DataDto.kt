package com.example.test_10.data.model

import com.squareup.moshi.Json

data class DataDto(
    @Json(name = "id")
    val id: Int
)