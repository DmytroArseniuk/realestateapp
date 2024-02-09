package com.arsars.realestateapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arsars.realestateapp.ui.navigation.DestinationArgs.PROPERTY_ID_ARG
import com.arsars.realestateapp.ui.navigation.Destinations.PROPERTY_DETAILS_ROUTE
import com.arsars.realestateapp.ui.navigation.Destinations.PROPERTY_LIST_ROUTE
import com.arsars.realestateapp.ui.screens.property.details.PropertyDetailsScreen
import com.arsars.realestateapp.ui.screens.property.list.PropertyListScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = PROPERTY_LIST_ROUTE,
    navActions: NavigationActions = remember(navController) {
        NavigationActions(navController)
    }
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = PROPERTY_LIST_ROUTE) {
            PropertyListScreen(
                openDetails = { navActions.navigateToPropertyDetailsScreen(it) }
            )
        }

        composable(
            route = PROPERTY_DETAILS_ROUTE,
            arguments = listOf(
                navArgument(PROPERTY_ID_ARG) { type = NavType.LongType }
            )
        ) {
            PropertyDetailsScreen(
                navigateUp = { navController.popBackStack() }
            )
        }

    }
}