package com.markgardie.gamificationtoolmobile.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.markgardie.gamificationtoolmobile.dashboard.screen.DashboardScreenWrapper
import com.markgardie.gamificationtoolmobile.dashboard.viewmodel.DashboardViewModel


const val dashboardScreenRoute = "dashboard_screen"

fun NavController.navigateToDashboard() {
    this.navigate(dashboardScreenRoute)
}


fun NavGraphBuilder.dashboardDestination(
    dashboardViewModel: DashboardViewModel
) {

    composable(
        route = dashboardScreenRoute,

        ) {

        DashboardScreenWrapper(dashboardViewModel)
    }
}