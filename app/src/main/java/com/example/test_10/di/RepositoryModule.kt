package com.example.test_10.di

import com.example.test_10.data.common.HandleResponse
import com.example.test_10.data.repository.DataRepositoryImpl
import com.example.test_10.data.repository.from.FromAccountRepositoryImpl
import com.example.test_10.data.repository.to.ToAccountRepositoryImpl
import com.example.test_10.data.service.DataService
import com.example.test_10.data.service.from.FromAccountService
import com.example.test_10.data.service.to.ToAccountService
import com.example.test_10.domain.repository.DataRepository
import com.example.test_10.domain.repository.from.FromAccountRepository
import com.example.test_10.domain.repository.to.ToAccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataRepository(
        handleResponse: HandleResponse,
        dataService: DataService
    ): DataRepository {
        return DataRepositoryImpl(handleResponse = handleResponse, dataService = dataService)
    }

    @Provides
    @Singleton
    fun provideFromAccountRepository(
        handleResponse: HandleResponse,
        fromAccountService: FromAccountService
    ): FromAccountRepository {
        return FromAccountRepositoryImpl(
            handleResponse = handleResponse,
            fromAccountService = fromAccountService
        )
    }

    @Provides
    @Singleton
    fun provideToAccountRepository(
        handleResponse: HandleResponse,
        toAccountService: ToAccountService
    ): ToAccountRepository {
        return ToAccountRepositoryImpl(
            handleResponse = handleResponse, toAccountService = toAccountService
        )
    }

}