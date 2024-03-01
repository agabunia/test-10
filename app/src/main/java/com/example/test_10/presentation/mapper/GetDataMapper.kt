package com.example.test_10.presentation.mapper

import com.example.test_10.domain.model.GetData
import com.example.test_10.presentation.model.Data

fun GetData.toPresenter(): Data {
    return Data(
        id = id
    )
}