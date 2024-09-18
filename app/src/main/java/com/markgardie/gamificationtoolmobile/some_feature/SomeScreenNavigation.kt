package com.markgardie.gamificationtoolmobile.some_feature

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val someScreenRoute = "some_screen"

fun NavController.navigateToSomeScreen() {
    this.navigate("some_screen")
}


fun NavGraphBuilder.someScreenDestination(
) {

    composable(
        route = someScreenRoute,

        ) {

        SomeScreen()
    }
}