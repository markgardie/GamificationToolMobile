package com.markgardie.gamificationtoolmobile.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.markgardie.gamificationtoolmobile.auth.repository.AuthRepository
import com.markgardie.gamificationtoolmobile.core.model.NetworkResult
import com.markgardie.gamificationtoolmobile.dashboard.repository.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val studentRepository: StudentRepository,
    private val authRepository: AuthRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    init {
        loadProfile()
    }

    private fun loadProfile() {
        viewModelScope.launch {
            _uiState.value = DashboardUiState.Loading
            when (val result = studentRepository.getProfile()) {
                is NetworkResult.Success -> {
                    if (result.data.pointSystems.isEmpty()) {
                        _uiState.value = DashboardUiState.Empty
                    } else {
                        _uiState.value = DashboardUiState.Success(
                            pointSystems = result.data.pointSystems
                        )
                    }
                }
                is NetworkResult.Error -> {
                    _uiState.value = DashboardUiState.Error(result.message)
                }
            }
        }
    }

    fun retry() {
        loadProfile()
    }

    fun logout() {
        authRepository.logout()
    }
}