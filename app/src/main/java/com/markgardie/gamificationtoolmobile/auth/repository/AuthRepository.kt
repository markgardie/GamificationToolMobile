package com.markgardie.gamificationtoolmobile.auth.repository

import com.markgardie.gamificationtoolmobile.core.model.NetworkResult

interface AuthRepository {

    suspend fun login(login: String, password: String): NetworkResult<Unit>
}