package com.markgardie.gamificationtoolmobile.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.markgardie.gamificationtoolmobile.dashboard.viewmodel.DashboardViewModel
import com.markgardie.gamificationtoolmobile.dashboard.navigation.dashboardDestination
import com.markgardie.gamificationtoolmobile.dashboard.navigation.dashboardScreenRoute


@Composable
fun GamificationNavHost() {

    val navController = rememberNavController()
    val dashboardViewModel: DashboardViewModel = hiltViewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )
    {

        NavHost(
            navController = navController,
            startDestination = dashboardScreenRoute,
        ) {

            dashboardDestination(dashboardViewModel)


        }

    }
}