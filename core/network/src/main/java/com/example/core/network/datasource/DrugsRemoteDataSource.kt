package com.example.core.network.datasource

import com.example.core.network.model.response.DrugsResponse

interface DrugsRemoteDataSource {

    suspend fun getDrugs(): DrugsResponse

}
