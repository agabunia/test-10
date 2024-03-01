package com.example.test_10.data.mapper

import com.example.test_10.data.model.DataDto
import com.example.test_10.domain.model.GetData

fun DataDto.toDomain(): GetData {
    return GetData(
        id = id
    )
}