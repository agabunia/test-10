package com.example.test_10.domain.usecase.to

import com.example.test_10.domain.repository.to.ToAccountRepository
import javax.inject.Inject

class GetToAccountUseCase @Inject constructor(
    private val repository: ToAccountRepository
) {
    suspend operator fun invoke() = repository.getToAccount()
}