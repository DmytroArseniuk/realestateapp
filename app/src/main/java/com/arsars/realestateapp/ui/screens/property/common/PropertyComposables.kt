package com.arsars.realestateapp.ui.screens.property.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.arsars.realestateapp.R
import com.arsars.realestateapp.domain.Property


@Composable
fun PropertyImage(
    modifier: Modifier = Modifier,
    property: Property
) {
    AsyncImage(
        model = property.url,
        contentDescription = "Property image",
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
    )
}

@Composable
fun PropertyImageStub(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .aspectRatio(2f)
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.Center)
                .size(64.dp),
            painter = painterResource(id = R.drawable.no_property_image),
            tint = Color.Gray,
            contentDescription = "Property image not available"
        )
    }

}
