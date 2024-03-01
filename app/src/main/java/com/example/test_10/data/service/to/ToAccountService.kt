package com.example.test_10.data.service.to

import com.example.test_10.data.model.to.ToAccountDto
import retrofit2.Response
import retrofit2.http.GET

interface ToAccountService {
    @GET("https://run.mocky.io/v3/4253786f-3500-4148-9ebc-1fe7fb9dc8d5?account_number=EU67JG7744036080300903")
    suspend fun getToAccount(): Response<ToAccountDto>
}
