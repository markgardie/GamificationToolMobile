package com.markgardie.gamificationtoolmobile.dashboard.api_service

import com.markgardie.gamificationtoolmobile.dashboard.model.StudentResponse
import retrofit2.http.GET

interface StudentApiService {

    @GET("student/profile")
    suspend fun getProfile(): StudentResponse
}