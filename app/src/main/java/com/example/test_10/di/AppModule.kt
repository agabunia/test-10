package com.example.test_10.di

import com.example.test_10.data.common.HandleResponse
import com.example.test_10.data.service.DataService
import com.example.test_10.data.service.from.FromAccountService
import com.example.test_10.data.service.to.ToAccountService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://run.mocky.io/v3/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Singleton
    @Provides
    fun provideHandleResponse(): HandleResponse {
        return HandleResponse()
    }

    @Singleton
    @Provides
    fun provideDataService(retrofit: Retrofit): DataService {
        return retrofit.create(DataService::class.java)
    }

    @Singleton
    @Provides
    fun provideFromAccountService(retrofit: Retrofit): FromAccountService {
        return retrofit.create(FromAccountService::class.java)
    }

    @Singleton
    @Provides
    fun provideToAccountService(retrofit: Retrofit): ToAccountService {
        return retrofit.create(ToAccountService::class.java)
    }

}