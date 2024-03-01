package com.example.test_10.data.repository.from

import com.example.test_10.data.common.HandleResponse
import com.example.test_10.data.common.Resource
import com.example.test_10.data.mapper.asResource
import com.example.test_10.data.mapper.from.toDomain
import com.example.test_10.data.service.from.FromAccountService
import com.example.test_10.domain.model.from.GetFromAccount
import com.example.test_10.domain.repository.from.FromAccountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FromAccountRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val fromAccountService: FromAccountService
) : FromAccountRepository {
    override suspend fun getFromAccount(): Flow<Resource<List<GetFromAccount>>> {
        return handleResponse.safeApiCall {
            fromAccountService.getFromAccount()
        }.asResource { list ->
            list.map {
                it.toDomain()
            }
        }
    }
}
