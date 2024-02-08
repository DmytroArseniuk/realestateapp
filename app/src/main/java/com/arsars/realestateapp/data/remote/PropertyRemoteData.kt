package com.arsars.realestateapp.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class PropertyRemoteData(
    val id: Long,
    val city: String,
    val area: Float,
    val price: Float,
    val professional: String,
    val propertyType: String,
    val offerType: Int,
    val url: String? = null,
    val bedrooms: Int? = null,
    val rooms: Int? = null
)
