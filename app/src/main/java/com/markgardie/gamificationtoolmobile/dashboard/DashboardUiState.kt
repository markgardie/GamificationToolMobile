package com.markgardie.gamificationtoolmobile.dashboard

sealed interface DashboardUiState {

    data class Success(val pointSystems: List<PointSystem>): DashboardUiState

    data class Error(val errorMessage: String): DashboardUiState

    object Empty: DashboardUiState

    object Loading: DashboardUiState
}