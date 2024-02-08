package com.arsars.realestateapp.ui.screens.property.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PropertyListScreen(
    modifier: Modifier = Modifier,
    openDetails: (id: String) -> Unit,
    viewModel: PropertyListViewModel = hiltViewModel()
) {
    Text(text = "PROPERTY_LIST")
}