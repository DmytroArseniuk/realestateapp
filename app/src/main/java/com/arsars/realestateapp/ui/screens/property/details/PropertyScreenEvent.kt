package com.arsars.realestateapp.ui.screens.property.details


sealed class PropertyScreenEvent {
    data object NavigateUp : PropertyScreenEvent()
}