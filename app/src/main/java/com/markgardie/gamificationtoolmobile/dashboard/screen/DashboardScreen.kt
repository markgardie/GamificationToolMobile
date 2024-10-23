package com.markgardie.gamificationtoolmobile.dashboard.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.markgardie.gamificationtoolmobile.dashboard.model.PointSystem
import com.markgardie.gamificationtoolmobile.dashboard.viewmodel.DashboardUiState
import com.markgardie.gamificationtoolmobile.dashboard.viewmodel.DashboardViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreenWrapper(
    dashboardViewModel: DashboardViewModel
) {
    val uiState by dashboardViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Дашборд") },
            )
        }
    ) { innerPadding ->

        when (uiState) {
            is DashboardUiState.Success -> DashboardScreen(
                pointSystems = (uiState as DashboardUiState.Success).pointSystems,
                innerPadding = innerPadding,
            )
            is DashboardUiState.Loading -> LoadingState(innerPadding = innerPadding)
            else -> EmptyState(innerPadding = innerPadding)
        }
    }


}


@Composable
fun DashboardScreen(
    pointSystems: List<PointSystem>,
    innerPadding: PaddingValues,
) {

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PointSystemItem(pointSystem: PointSystem) {
    ListItem(
        headlineText = { Text(pointSystem.name, fontWeight = FontWeight.Medium) },
        supportingText = { Text("Value: ${pointSystem.value}") },
    )
}

@Composable
fun LoadingState(
    innerPadding: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }

}

@Composable
fun EmptyState(
    innerPadding: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Немає балів")

    }
}