package com.arsars.realestateapp.data

import com.arsars.realestateapp.data.mappers.PropertyRemoteDataToPropertyMapper
import com.arsars.realestateapp.domain.Property
import com.arsars.realestateapp.domain.PropertyRepository
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    private val propertyRemoteDataSource: PropertiesRemoteDataSource,
    private val remoteDataMapper: PropertyRemoteDataToPropertyMapper
) : PropertyRepository {
    override suspend fun getAllProperties(): List<Property> {
        return propertyRemoteDataSource.getProperties().map(remoteDataMapper::map)
    }

    override suspend fun getProperty(id: Long): Property {
        return propertyRemoteDataSource.getProperty(id).let(remoteDataMapper::map)
    }
}