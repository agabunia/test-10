package com.example.test_10.data.repository.to

import com.example.test_10.data.common.HandleResponse
import com.example.test_10.data.common.Resource
import com.example.test_10.data.mapper.asResource
import com.example.test_10.data.mapper.to.toDomain
import com.example.test_10.data.service.to.ToAccountService
import com.example.test_10.domain.model.to.GetToAccount
import com.example.test_10.domain.repository.to.ToAccountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToAccountRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val toAccountService: ToAccountService
) : ToAccountRepository {
    override suspend fun getToAccount(): Flow<Resource<GetToAccount>> {
        return handleResponse.safeApiCall {
            toAccountService.getToAccount()
        }.asResource {
            it.toDomain()
        }
    }
}