package com.arsars.realestateapp.ui.screens.property.list

import com.arsars.realestateapp.domain.Property

data class PropertiesScreenState(
    val isLoading: Boolean = false,
    val properties: List<Property> = emptyList()
)
