package com.arsars.realestateapp.domain

data class Property(
    val id: Long,
    val city: String,
    val area: Float,
    val price: Double,
    val professional: String,
    val propertyType: String,
    val offerType: Int,
    val url: String?,
    val bedrooms: Int?,
    val rooms: Int?
)
