package com.example.test_10.domain.repository.from

import com.example.test_10.data.common.Resource
import com.example.test_10.domain.model.from.GetFromAccount
import kotlinx.coroutines.flow.Flow

interface FromAccountRepository {
    suspend fun getFromAccount(): Flow<Resource<List<GetFromAccount>>>
}
