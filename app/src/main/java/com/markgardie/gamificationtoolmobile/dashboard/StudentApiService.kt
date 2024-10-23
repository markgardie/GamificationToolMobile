package com.markgardie.gamificationtoolmobile.dashboard

import retrofit2.http.GET

interface StudentApiService {

    @GET("student/profile")
    suspend fun getProfile(): StudentResponse
}