package com.example.core.data.repository

import com.example.core.common.injection.IoDispatcher
import com.example.core.common.util.NetworkHelper
import com.example.core.data.local.DrugsDataBase
import com.example.core.network.datasource.DrugsRemoteDataSource
import com.example.core.network.model.response.Drug
import com.example.core.network.model.response.DrugsResponse
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface DrugRepository {

    suspend fun getDrugsFromRemote(): DrugsResponse

    fun getDrugsFromDb(): List<Drug>

    suspend fun cachingDrugs()

    suspend fun insertDrug()

    suspend fun deleteDrugs()

}

class DefaultDrugsRepository
    @Inject
    constructor(
        private val drugsRemoteDataSource: DrugsRemoteDataSource,
        private val drugsDataBase: DrugsDataBase,
        private val networkHelper: NetworkHelper,
        @IoDispatcher private val defaultDispatcher: CoroutineDispatcher,
    ) : DrugRepository {

    override suspend fun getDrugsFromRemote(): DrugsResponse {
        return  drugsRemoteDataSource.getDrugs()
    }

    override fun getDrugsFromDb(): List<Drug>  {
        return  drugsDataBase.getDrugsDao().getAllDrugs()
    }

    override suspend fun cachingDrugs() {
        if (drugsDataBase.getDrugsDao().getAllDrugs().isEmpty()) {
            if (networkHelper.isInternetAvailable()) {
                getDrugsFromRemote()
                deleteDrugs()
                insertDrug()
            }
        }
    }

    override suspend fun insertDrug() {
        drugsRemoteDataSource.getDrugs().drugs.map { drug ->
            drugsDataBase.getDrugsDao().insertDrug(drug)
        }
    }

    override suspend fun deleteDrugs() {
        drugsDataBase.getDrugsDao().deleteAllDrugs()
    }


}

