package com.arsars.realestateapp.data.remote.api

import com.arsars.realestateapp.data.remote.PropertyRemoteData
import kotlinx.serialization.Serializable

@Serializable
data class PropertiesResponse(
    val items: List<PropertyRemoteData>,
    val totalCount: Int
)
