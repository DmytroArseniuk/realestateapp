package com.arsars.realestateapp.ui.screens.property.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arsars.realestateapp.ui.screens.property.common.PropertyImage
import com.arsars.realestateapp.ui.screens.property.common.PropertyImageStub
import com.arsars.realestateapp.ui.utils.formatArea
import com.arsars.realestateapp.ui.utils.formatPrice

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PropertyDetailsScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    viewModel: PropertyDetailsViewModel = hiltViewModel()
) {

    LaunchedEffect(true) {
        viewModel.screenEvent.collect {
            when (it) {
                PropertyScreenEvent.NavigateUp -> navigateUp()
            }
        }
    }
    val screenState = viewModel.screenState.collectAsState()

    val pullToRefreshState = rememberPullToRefreshState()
    if (pullToRefreshState.isRefreshing) {
        LaunchedEffect(true) {
            viewModel.loadProperty()
        }
    }
    LaunchedEffect(screenState.value.isLoading) {
        if (screenState.value.isLoading) {
            pullToRefreshState.startRefresh()
        } else {
            pullToRefreshState.endRefresh()
        }
    }


    Box(Modifier.nestedScroll(pullToRefreshState.nestedScrollConnection)) {
        PropertyView(modifier, screenState, navigateUp)
        PullToRefreshContainer(
            modifier = Modifier.align(Alignment.TopCenter),
            state = pullToRefreshState,
        )
    }
}

@Composable
private fun PropertyView(
    modifier: Modifier,
    state: State<PropertyScreenState>,
    navigateUp: () -> Unit
) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        state.value.property?.let { property ->
            Box {
                if (property.url.isNullOrEmpty()) {
                    PropertyImageStub()
                } else {
                    PropertyImage(property = property)
                }
                IconButton(onClick = { navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "City: ${property.city}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Price: ${property.price.formatPrice()}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Area: ${property.area.formatArea()}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Bedrooms: ${property.bedrooms ?: "Unknown"}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Rooms: ${property.rooms ?: "Unknown"}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Type: ${property.propertyType}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Professional: ${property.professional}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}