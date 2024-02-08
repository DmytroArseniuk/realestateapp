package com.arsars.realestateapp.ui.screens.property.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PropertyListScreen(
    modifier: Modifier = Modifier,
    openDetails: (id: String) -> Unit
) {
    Text(text = "PROPERTY_LIST")
}