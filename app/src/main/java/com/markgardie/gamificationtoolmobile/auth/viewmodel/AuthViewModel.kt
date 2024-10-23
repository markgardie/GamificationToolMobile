package com.markgardie.gamificationtoolmobile.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.markgardie.gamificationtoolmobile.auth.repository.AuthRepository
import com.markgardie.gamificationtoolmobile.auth.util.TokenManager
import com.markgardie.gamificationtoolmobile.core.model.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Initial)
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun login(login: String, password: String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading

            when (val result = repository.login(login, password)) {
                is NetworkResult.Success -> {
                    _uiState.value = AuthUiState.Success
                }
                is NetworkResult.Error -> {
                    _uiState.value = AuthUiState.Error(result.message)
                }
            }
        }
    }

    fun logOut() {
        viewModelScope.launch {
            TokenManager.clearToken()
            _uiState.value = AuthUiState.Initial
        }
    }
}