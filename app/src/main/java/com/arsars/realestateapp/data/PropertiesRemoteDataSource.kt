package com.arsars.realestateapp.data

import com.arsars.realestateapp.data.remote.PropertyRemoteData

interface PropertiesRemoteDataSource {
    suspend fun getProperties(): List<PropertyRemoteData>

    suspend fun getProperty(id: Long): PropertyRemoteData

}