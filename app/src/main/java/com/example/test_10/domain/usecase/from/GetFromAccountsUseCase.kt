package com.example.test_10.domain.usecase.from

import com.example.test_10.domain.repository.from.FromAccountRepository
import javax.inject.Inject

class GetFromAccountsUseCase @Inject constructor(private val repository: FromAccountRepository) {
    suspend operator fun invoke() = repository.getFromAccount()
}
