package com.example.test.injection

import com.example.core.network.datasource.DrugsRemoteDataSource
import com.example.core.network.injection.NetworkModule
import com.example.core.network.service.MockyApi
import com.example.test.test.data.FakeDrugRemoteDataSource
import com.example.test.test.network.FakeDrugListApi
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class],
)
abstract class TestNetworkModule {
    @[Binds Singleton]
    abstract fun DrugsRemoteDataSource(
        dataSource: FakeDrugRemoteDataSource,
    ): DrugsRemoteDataSource



    @[Binds Singleton]
    abstract fun provideDrugApi(repo: FakeDrugListApi): MockyApi

}
