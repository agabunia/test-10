package com.example.test_10.presentation.mapper.to

import com.example.test_10.domain.model.to.GetToAccount
import com.example.test_10.presentation.model.to.ToAccount

fun GetToAccount.toPresenter(): ToAccount {
    return ToAccount(
        id = id,
        accountName = accountName,
        accountNumber = accountNumber,
        currencyType = currencyType,
        cardType = cardType,
        cardLogo = cardLogo
    )
}