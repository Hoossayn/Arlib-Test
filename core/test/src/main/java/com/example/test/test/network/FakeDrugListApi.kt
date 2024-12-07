package com.example.test.test.network

import com.example.core.network.model.response.DrugsResponse
import com.example.core.network.service.MockyApi
import com.example.test.util.DrugsTestData
import javax.inject.Inject

class FakeDrugListApi
    @Inject
    constructor() : MockyApi {

    override suspend fun getDrugs(): DrugsResponse =
        DrugsTestData.drugResponse()
}
