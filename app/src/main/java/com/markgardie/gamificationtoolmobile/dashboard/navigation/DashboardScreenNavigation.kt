package com.markgardie.gamificationtoolmobile.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.markgardie.gamificationtoolmobile.auth.navigation.navigateToAuth
import com.markgardie.gamificationtoolmobile.dashboard.screen.DashboardScreenWrapper


const val dashboardScreenRoute = "dashboard_screen"

fun NavController.navigateToDashboard() {
    this.navigate(dashboardScreenRoute)
}


fun NavGraphBuilder.dashboardDestination(
    navController: NavController
) {

    composable(
        route = dashboardScreenRoute,

        ) {

        DashboardScreenWrapper(onLogout = { navController.navigateToAuth() })
    }
}