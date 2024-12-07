package com.example.core.data.injection

import com.example.core.data.repository.DefaultDrugsRepository
import com.example.core.data.repository.DrugRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun provideDrugsRepository(repository: DefaultDrugsRepository): DrugRepository


}
