package com.example.test_10.domain.repository.to

import com.example.test_10.data.common.Resource
import com.example.test_10.domain.model.to.GetToAccount
import kotlinx.coroutines.flow.Flow

interface ToAccountRepository {
    suspend fun getToAccount(): Flow<Resource<GetToAccount>>
}