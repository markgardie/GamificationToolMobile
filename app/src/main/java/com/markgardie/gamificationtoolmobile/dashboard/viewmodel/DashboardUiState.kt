package com.markgardie.gamificationtoolmobile.dashboard.viewmodel

sealed interface DashboardUiState {
    data class Success(val pointSystems: Map<String, Int>): DashboardUiState
    data class Error(val errorMessage: String): DashboardUiState
    object Empty: DashboardUiState
    object Loading: DashboardUiState
}