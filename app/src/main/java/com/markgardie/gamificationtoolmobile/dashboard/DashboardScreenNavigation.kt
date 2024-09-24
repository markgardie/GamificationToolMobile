package com.markgardie.gamificationtoolmobile.dashboard

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val dashboardScreenRoute = "dashboard_screen"

fun NavController.navigateToDashboard() {
    this.navigate(dashboardScreenRoute)
}


fun NavGraphBuilder.dashboardDestination(
) {

    composable(
        route = dashboardScreenRoute,

        ) {

        DashboardScreenWrapper()
    }
}