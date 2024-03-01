package com.example.test_10.presentation.mapper.from

import com.example.test_10.domain.model.from.GetFromAccount
import com.example.test_10.presentation.model.from.FromAccount

fun GetFromAccount.toPresenter(): FromAccount {
    return FromAccount(
        id = id,
        accountName = accountName,
        accountNumber = accountNumber,
        currencyType = currencyType,
        cardType = cardType,
        balance = balance,
        cardLogo = cardLogo
    )
}