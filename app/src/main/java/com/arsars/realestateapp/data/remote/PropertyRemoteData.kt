package com.arsars.realestateapp.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class PropertyRemoteData(
    val bedrooms: Int,
    val city: String,
    val id: Long,
    val area: Float,
    val url: String,
    val price: Float,
    val professional: String,
    val propertyType: String,
    val offerType: Int,
    val rooms: Int
)
