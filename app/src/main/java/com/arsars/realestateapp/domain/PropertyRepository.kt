package com.arsars.realestateapp.domain

interface PropertyRepository {
    suspend fun getAllProperties(): List<Property>
    suspend fun getProperty(id: String): Property
}