package com.example.test.test.data

import com.example.core.network.datasource.DrugsRemoteDataSource
import com.example.core.network.model.response.DrugsResponse
import com.example.test.util.DrugsTestData.drugResponse
import javax.inject.Inject

class FakeDrugRemoteDataSource
    @Inject
    constructor() : DrugsRemoteDataSource {

    override suspend fun getDrugs(): DrugsResponse = drugResponse()
}
