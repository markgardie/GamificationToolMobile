package com.markgardie.gamificationtoolmobile.dashboard.viewmodel

import com.markgardie.gamificationtoolmobile.dashboard.model.PointSystem

sealed interface DashboardUiState {

    data class Success(val pointSystems: List<PointSystem>): DashboardUiState

    data class Error(val errorMessage: String): DashboardUiState

    object Empty: DashboardUiState

    object Loading: DashboardUiState
}