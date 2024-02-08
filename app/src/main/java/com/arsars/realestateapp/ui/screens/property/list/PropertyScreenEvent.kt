package com.arsars.realestateapp.ui.screens.property.list

sealed class PropertyScreenEvent {
    data class OpenPropertyDetails(val id: Long) : PropertyScreenEvent()
}