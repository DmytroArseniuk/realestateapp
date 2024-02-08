package com.arsars.realestateapp.data.mappers

import com.arsars.realestateapp.data.remote.PropertyRemoteData
import com.arsars.realestateapp.domain.Property

class PropertyRemoteDataToPropertyMapper {
    fun map(remoteProperty: PropertyRemoteData): Property {
        return Property(
            id = remoteProperty.id,
            area = remoteProperty.area,
            bedrooms = remoteProperty.bedrooms,
            city = remoteProperty.city,
            offerType = remoteProperty.offerType,
            propertyType = remoteProperty.propertyType,
            url = remoteProperty.url,
            price = remoteProperty.price,
            professional = remoteProperty.professional,
            rooms = remoteProperty.rooms
        )
    }
}