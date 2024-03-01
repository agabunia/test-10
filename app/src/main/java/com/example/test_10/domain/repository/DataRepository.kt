package com.example.test_10.domain.repository

import com.example.test_10.data.common.Resource
import com.example.test_10.domain.model.GetData
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    suspend fun getData(): Flow<Resource<GetData>>
}
