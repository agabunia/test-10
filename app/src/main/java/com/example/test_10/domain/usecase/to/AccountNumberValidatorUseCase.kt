package com.example.test_10.domain.usecase.to

import javax.inject.Inject

class AccountNumberValidatorUseCase @Inject constructor() {
    operator fun invoke(userInput: String, fetchedData: String): Boolean {
        return userInput == fetchedData
    }
}