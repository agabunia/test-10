package com.example.test_10.data.service

import com.example.test_10.data.model.DataDto
import retrofit2.Response
import retrofit2.http.GET

interface DataService {
    @GET("")
    suspend fun getData(): Response<DataDto>
}
