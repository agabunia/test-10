package com.example.test_10.data.service.from

import com.example.test_10.data.model.from.FromAccountDto
import retrofit2.Response
import retrofit2.http.GET

interface FromAccountService {
    @GET("https://run.mocky.io/v3/5c74ec0e-5cc1-445e-b64b-b76b286b215f")
    suspend fun getFromAccount(): Response<List<FromAccountDto>>
}