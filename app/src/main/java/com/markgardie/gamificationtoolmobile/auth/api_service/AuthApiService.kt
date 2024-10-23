package com.markgardie.gamificationtoolmobile.auth.api_service

import com.markgardie.gamificationtoolmobile.auth.models.LoginRequest
import com.markgardie.gamificationtoolmobile.auth.models.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}