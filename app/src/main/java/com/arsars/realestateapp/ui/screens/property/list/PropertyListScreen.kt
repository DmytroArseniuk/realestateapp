package com.arsars.realestateapp.ui.screens.property.list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arsars.realestateapp.R
import com.arsars.realestateapp.domain.Property
import com.arsars.realestateapp.ui.screens.property.common.PropertyImage
import com.arsars.realestateapp.ui.screens.property.common.PropertyImageStub
import com.arsars.realestateapp.ui.utils.formatArea
import com.arsars.realestateapp.ui.utils.formatPrice

@Composable
fun PropertyListScreen(
    modifier: Modifier = Modifier,
    openDetails: (id: Long) -> Unit,
    viewModel: PropertyListViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        viewModel.screenEvent.collect {
            when (it) {
                is PropertyScreenEvent.OpenPropertyDetails -> openDetails(it.id)
            }
        }
    }

    val screenState = viewModel.screenState.collectAsState()

    LazyColumn(modifier) {
        items(
            items = screenState.value.properties,
            key = { it.id }
        ) {
            PropertyItem(property = it) { viewModel.openPropertyDetails(it) }
        }
    }
}

@Composable
fun PropertyItem(
    modifier: Modifier = Modifier,
    property: Property,
    itemClicked: (Property) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { itemClicked(property) }
    ) {
        Column {
            if (property.url.isNullOrEmpty()) {
                PropertyImageStub()
            } else {
                PropertyImage(property = property)
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = property.city, style = MaterialTheme.typography.headlineSmall)
                Text(
                    text = property.price.formatPrice(),
                    style = MaterialTheme.typography.titleMedium
                )
                PropertyFooter(
                    modifier = Modifier.padding(top = 16.dp),
                    property
                )
            }
        }
    }
}

@Composable
private fun PropertyFooter(
    modifier: Modifier = Modifier,
    property: Property
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TextWithIcon(id = R.drawable.ic_area) {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = property.area.formatArea(),
                style = MaterialTheme.typography.bodyLarge

            )
        }
        if (property.rooms != null) {
            TextWithIcon(id = R.drawable.ic_room) {
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = property.rooms.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        if (property.bedrooms != null) {
            TextWithIcon(id = R.drawable.ic_bedroom) {
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = property.bedrooms.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun TextWithIcon(
    modifier: Modifier = Modifier,
    @DrawableRes id: Int,
    text: @Composable () -> Unit
) {
    Row(modifier = modifier) {
        Icon(painter = painterResource(id), contentDescription = "")
        text()
    }
}
