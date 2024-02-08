package com.arsars.realestateapp.data.remote

import com.arsars.realestateapp.data.PropertiesRemoteDataSource
import com.arsars.realestateapp.data.remote.api.PropertiesApi
import javax.inject.Inject

class PropertiesRemoteDataSourceImpl @Inject constructor(
    private val propertiesApi: PropertiesApi
) : PropertiesRemoteDataSource {

    override suspend fun getProperties(): List<PropertyRemoteData> {
        return propertiesApi.getProperties().items
    }

    override suspend fun getProperty(id: Long): PropertyRemoteData {
        return propertiesApi.getProperty(id)
    }
}