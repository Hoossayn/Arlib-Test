package com.example.core.network.datasource

import com.example.core.network.model.response.DrugsResponse
import com.example.core.network.service.MockyApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultDrugsDataSource @Inject constructor(
    val mockyApi: MockyApi
): DrugsRemoteDataSource{

    override suspend fun getDrugs(): DrugsResponse =
        mockyApi.getDrugs()

}