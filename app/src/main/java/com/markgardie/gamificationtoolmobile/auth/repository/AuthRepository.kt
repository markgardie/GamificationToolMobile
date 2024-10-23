package com.markgardie.gamificationtoolmobile.auth.repository

import com.markgardie.gamificationtoolmobile.core.models.NetworkResult

interface AuthRepository {

    suspend fun login(login: String, password: String): NetworkResult<Unit>
}