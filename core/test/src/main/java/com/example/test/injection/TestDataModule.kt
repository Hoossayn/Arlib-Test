package com.example.test.injection

import com.example.core.data.injection.DataModule
import com.example.core.data.repository.DrugRepository
import com.example.test.test.data.FakeDrugsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class],
)
abstract class TestDataModule {
    @[Binds Singleton]
    abstract fun provideFakeDrugRepository(repo: FakeDrugsRepository): DrugRepository

}
