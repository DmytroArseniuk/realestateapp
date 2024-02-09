package com.arsars.realestateapp

import com.arsars.realestateapp.domain.Property

object PropertiesStub {
    val allProperties = listOf(
        Property(
            bedrooms = 4,
            city = "Villers-sur-Mer",
            id = 1,
            area = 250.0f,
            url = "https://v.seloger.com/s/crop/590x330/visuels/1/7/t/3/17t3fitclms3bzwv8qshbyzh9dw32e9l0p0udr80k.jpg",
            price = 1500000.0,
            professional = "GSL EXPLORE",
            propertyType = "Maison - Villa",
            offerType = 1,
            rooms = 8
        ),
        Property(
            bedrooms = 7,
            city = "Deauville",
            id = 2,
            area = 600.0f,
            url = "https://v.seloger.com/s/crop/590x330/visuels/2/a/l/s/2als8bgr8sd2vezcpsj988mse4olspi5rfzpadqok.jpg",
            price = 3500000.0,
            professional = "GSL STICKINESS",
            propertyType = "Maison - Villa",
            offerType = 2,
            rooms = 11
        )
    )
}