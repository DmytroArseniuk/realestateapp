package com.arsars.realestateapp.ui.screens.property.list

sealed class PropertyScreenEvent {
    data class OpenPropertyDetails(val id: Long) : PropertyScreenEvent()
    data class ShowError(val message: String) : PropertyScreenEvent()
}