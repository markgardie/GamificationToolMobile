package com.markgardie.gamificationtoolmobile.auth.repository

import com.markgardie.gamificationtoolmobile.auth.util.TokenManager
import com.markgardie.gamificationtoolmobile.auth.api_service.AuthApiService
import com.markgardie.gamificationtoolmobile.auth.models.LoginRequest
import com.markgardie.gamificationtoolmobile.core.models.NetworkResult
import javax.inject.Inject

class NetworkAuthRepository @Inject constructor(
    private val apiService: AuthApiService,
    private val tokenManager: TokenManager
): AuthRepository {

    override suspend fun login(login: String, password: String): NetworkResult<Unit> {
        return try {
            val response = apiService.login(LoginRequest(login, password))
            TokenManager.saveToken(response.token)
            NetworkResult.Success(Unit)
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Unknown error occurred")
        }
    }
}