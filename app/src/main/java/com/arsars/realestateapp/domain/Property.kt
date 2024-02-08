package com.arsars.realestateapp.domain

data class Property(
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
