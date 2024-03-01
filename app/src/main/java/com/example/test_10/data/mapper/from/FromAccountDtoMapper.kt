package com.example.test_10.data.mapper.from

import com.example.test_10.data.model.from.FromAccountDto
import com.example.test_10.domain.model.from.GetFromAccount

fun FromAccountDto.toDomain(): GetFromAccount {
    return GetFromAccount(
        id = id,
        accountName = accountName,
        accountNumber = accountNumber,
        currencyType = currencyType,
        cardType = cardType,
        balance = balance,
        cardLogo = cardLogo
    )
}