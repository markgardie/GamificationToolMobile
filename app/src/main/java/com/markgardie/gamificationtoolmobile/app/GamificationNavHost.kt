package com.markgardie.gamificationtoolmobile.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.markgardie.gamificationtoolmobile.dashboard.dashboardDestination
import com.markgardie.gamificationtoolmobile.dashboard.dashboardScreenRoute


@Composable
fun GamificationNavHost() {

    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )
    {

        NavHost(
            navController = navController,
            startDestination = dashboardScreenRoute,
        ) {

            dashboardDestination()


        }

    }
}