package com.markgardie.gamificationtoolmobile.dashboard.repository

import com.markgardie.gamificationtoolmobile.dashboard.model.PointSystem
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {

    fun getPointSystemsStream(): Flow<List<PointSystem>>
}