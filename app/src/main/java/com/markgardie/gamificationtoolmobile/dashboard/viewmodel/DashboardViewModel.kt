package com.markgardie.gamificationtoolmobile.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.markgardie.gamificationtoolmobile.app.di.TestRepository
import com.markgardie.gamificationtoolmobile.dashboard.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    @TestRepository val dashboardRepository: DashboardRepository
): ViewModel() {

    val uiState: StateFlow<DashboardUiState> = dashboardRepository
        .getPointSystemsStream()
        .map { pointSystems ->
            if (pointSystems.isEmpty()) DashboardUiState.Empty
            else DashboardUiState.Success(pointSystems = pointSystems)
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            DashboardUiState.Loading
        )

}