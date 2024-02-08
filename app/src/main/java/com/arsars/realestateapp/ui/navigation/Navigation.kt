package com.arsars.realestateapp.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.arsars.realestateapp.ui.navigation.DestinationArgs.PROPERTY_ID_ARG
import com.arsars.realestateapp.ui.navigation.Destinations.PROPERTY_LIST_ROUTE
import com.arsars.realestateapp.ui.navigation.Screens.PROPERTY_DETAILS
import com.arsars.realestateapp.ui.navigation.Screens.PROPERTY_LIST

private object Screens {
    const val PROPERTY_LIST = "property_list"
    const val PROPERTY_DETAILS = "property_details"
}

object Destinations {
    const val PROPERTY_LIST_ROUTE = PROPERTY_LIST
    const val PROPERTY_DETAILS_ROUTE = "$PROPERTY_DETAILS/{$PROPERTY_ID_ARG}"
}

object DestinationArgs {
    const val PROPERTY_ID_ARG = "id"
}

class NavigationActions(
    private val navController: NavHostController
) {
    fun navigateToPropertyListScreen() {
        navController.navigate(PROPERTY_LIST_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    fun navigateToPropertyDetailsScreen(id: Long) {
        navController.navigate("$PROPERTY_DETAILS/$id")
    }
}

