package com.markgardie.gamificationtoolmobile.dashboard.repository

import com.markgardie.gamificationtoolmobile.core.model.NetworkResult
import com.markgardie.gamificationtoolmobile.dashboard.model.StudentResponse

interface StudentRepository {
    suspend fun getProfile(): NetworkResult<StudentResponse>
}