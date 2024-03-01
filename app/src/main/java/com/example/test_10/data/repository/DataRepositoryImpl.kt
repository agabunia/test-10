package com.example.test_10.data.repository

import com.example.test_10.data.common.HandleResponse
import com.example.test_10.data.common.Resource
import com.example.test_10.data.mapper.asResource
import com.example.test_10.data.mapper.toDomain
import com.example.test_10.data.service.DataService
import com.example.test_10.domain.model.GetData
import com.example.test_10.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val dataService: DataService
) : DataRepository {
    override suspend fun getData(): Flow<Resource<GetData>> {
        return handleResponse.safeApiCall {
            dataService.getData()
        }.asResource {
            it.toDomain()
        }
    }
}
