package com.arsars.realestateapp.data.remote.api

import com.arsars.realestateapp.data.remote.PropertyRemoteData
import retrofit2.http.GET
import retrofit2.http.Path

interface PropertiesApi {
    @GET("/listings.json")
    suspend fun getProperties(): PropertiesResponse

    @GET("/listings/{listingId}.json")
    suspend fun getProperty(@Path("listingId") id: Long): PropertyRemoteData
}