package com.markgardie.gamificationtoolmobile.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight


@Composable
fun DashboardScreenWrapper() {
    
    val testPointSystem = listOf(
        PointSystem(1, "Логіки", 0),
        PointSystem(2, "Технічні навички", 0),
        PointSystem(3, "Командна робота", 0),
        PointSystem(4, "Креативність", 0),
    )

    DashboardScreen(testPointSystem)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(pointSystems: List<PointSystem>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Дашборд") },
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(pointSystems) { pointSystem ->
                PointSystemItem(pointSystem)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PointSystemItem(pointSystem: PointSystem) {
    ListItem(
        headlineText = { Text(pointSystem.name, fontWeight = FontWeight.Medium) },
        supportingText = { Text("Value: ${pointSystem.value}") },
    )
}