package com.example.core.network.service

import com.example.core.network.model.response.DrugsResponse
import retrofit2.http.GET

interface MockyApi {

    @GET("66d0c037-97d4-4d87-8ed4-1da7a3ed2be5")
    suspend fun getDrugs(): DrugsResponse
}