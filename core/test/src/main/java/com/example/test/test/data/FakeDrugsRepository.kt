package com.example.test.test.data

import com.example.core.data.repository.DrugRepository
import com.example.core.network.model.response.Drug
import com.example.core.network.model.response.DrugsResponse
import com.example.test.util.DrugsTestData.drugResponse
import com.example.test.util.DrugsTestData.result
import javax.inject.Inject

class FakeDrugsRepository @Inject constructor() : DrugRepository {

    override suspend fun getDrugsFromRemote(): DrugsResponse = drugResponse()

    override fun getDrugsFromDb(): List<Drug> {
        return  result()
    }

    override suspend fun cachingDrugs() {
        return
    }

    override suspend fun insertDrug() {
        return
    }

    override suspend fun deleteDrugs() {
        return
    }
}
