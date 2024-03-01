package com.example.test_10.domain.usecase.to

import javax.inject.Inject

class CustomerIdValidatorUseCase @Inject constructor() {
    operator fun invoke(userInput: String): Boolean {
        return userInput.length == 11
    }
}