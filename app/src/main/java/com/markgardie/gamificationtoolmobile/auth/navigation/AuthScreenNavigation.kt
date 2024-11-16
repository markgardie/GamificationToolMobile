package com.markgardie.gamificationtoolmobile.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.markgardie.gamificationtoolmobile.auth.screen.AuthScreenWrapper
import com.markgardie.gamificationtoolmobile.dashboard.navigation.navigateToDashboard

const val authScreenRoute = "auth_screen"

fun NavController.navigateToAuth() {
    this.navigate(authScreenRoute)
}


fun NavGraphBuilder.authDestination(
    navController: NavController
) {

    composable(
        route = authScreenRoute,
    ) {

        AuthScreenWrapper(
            onAuthSuccess = {
                navController.navigateToDashboard()
            }
        )
    }
}