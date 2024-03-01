package com.example.test_10.data.mapper.to

import com.example.test_10.data.model.to.ToAccountDto
import com.example.test_10.domain.model.to.GetToAccount

fun ToAccountDto.toDomain(): GetToAccount {
    return GetToAccount(
        id = id,
        accountName = accountName,
        accountNumber = accountNumber,
        currencyType = currencyType,
        cardType = cardType,
        cardLogo = cardLogo
    )
}
