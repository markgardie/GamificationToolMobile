package com.markgardie.gamificationtoolmobile.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.markgardie.gamificationtoolmobile.some_feature.someScreenDestination
import com.markgardie.gamificationtoolmobile.some_feature.someScreenRoute


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
            startDestination = someScreenRoute,
        ) {

            someScreenDestination()


        }

    }
}