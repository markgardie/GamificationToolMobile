package com.markgardie.gamificationtoolmobile.dashboard.repository

import com.markgardie.gamificationtoolmobile.core.model.NetworkResult
import com.markgardie.gamificationtoolmobile.dashboard.api_service.StudentApiService
import com.markgardie.gamificationtoolmobile.dashboard.model.StudentResponse
import javax.inject.Inject


class NetworkStudentRepository @Inject constructor(
    private val apiService: StudentApiService
) : StudentRepository {

    override suspend fun getProfile(): NetworkResult<StudentResponse> {
        return try {
            val response = apiService.getProfile()
            NetworkResult.Success(response)
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Unknown error occurred")
        }
    }
}