package com.example.test_10.domain.usecase.to

import javax.inject.Inject

class PhoneValidatorUseCase @Inject constructor() {
    operator fun invoke(userInput: String): Boolean {
        return userInput.length == 9 && userInput[0] == '5'
    }
}