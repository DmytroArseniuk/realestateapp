package com.arsars.realestateapp.ui.utils

fun Double.formatPrice(): String {
    return "€ ${"%,d".format(this.toInt())}"
}

fun Float.formatArea(): String {
    return "${this.toInt()} \u33A1"
}

