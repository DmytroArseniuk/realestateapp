package com.arsars.realestateapp.ui.screens.property.details


sealed class PropertyScreenEvent {
    data object NavigateUp : PropertyScreenEvent()
    data class ShowError(val message: String) : PropertyScreenEvent()
}