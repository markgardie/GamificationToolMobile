package com.markgardie.gamificationtoolmobile.dashboard.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.markgardie.gamificationtoolmobile.core.ui_components.EmptyState
import com.markgardie.gamificationtoolmobile.core.ui_components.LoadingState
import com.markgardie.gamificationtoolmobile.dashboard.viewmodel.DashboardUiState
import com.markgardie.gamificationtoolmobile.dashboard.viewmodel.DashboardViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreenWrapper(
    dashboardViewModel: DashboardViewModel = hiltViewModel(),
    onLogout: () -> Unit,
) {
    val uiState by dashboardViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Дашборд") },
                actions = {
                    IconButton(onClick = { dashboardViewModel.retry() }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Оновити"
                        )
                    }
                    IconButton(
                        onClick = {
                            dashboardViewModel.logout()
                            onLogout()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = "Вийти"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        when (uiState) {
            is DashboardUiState.Success -> DashboardScreen(
                pointSystems = (uiState as DashboardUiState.Success).pointSystems,
                innerPadding = innerPadding,
            )
            is DashboardUiState.Loading -> LoadingState(innerPadding = innerPadding)
            is DashboardUiState.Error -> ErrorState(
                errorMessage = (uiState as DashboardUiState.Error).errorMessage,
                onRetry = { dashboardViewModel.retry() },
                innerPadding = innerPadding
            )
            is DashboardUiState.Empty -> EmptyState(
                innerPadding = innerPadding,
                emptyMessage = "Немає балів"
            )
        }
    }
}

@Composable
fun DashboardScreen(
    pointSystems: Map<String, Int>,
    innerPadding: PaddingValues,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        items(pointSystems.entries.toList()) { (name, value) ->
            PointSystemItem(name = name, value = value)
        }
    }
}

@Composable
fun PointSystemItem(name: String, value: Int) {
    ListItem(
        headlineContent = { Text(name, fontWeight = FontWeight.Medium) },
        supportingContent = { Text("Кількість: $value") },
    )
}


@Composable
fun ErrorState(
    errorMessage: String,
    onRetry: () -> Unit,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = errorMessage)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text("Спробувати знову")
        }
    }
}

@Composable
fun EmptyState(
    innerPadding: PaddingValues,
    emptyMessage: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = emptyMessage)
    }
}

@Composable
fun LoadingState(innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

