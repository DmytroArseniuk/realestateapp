package com.arsars.realestateapp.ui.screens.property.details

import com.arsars.realestateapp.domain.Property

data class PropertyScreenState(
    val isLoading: Boolean = false,
    val property: Property? = null
) {
}