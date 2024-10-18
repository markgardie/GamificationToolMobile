package com.markgardie.gamificationtoolmobile.dashboard

import kotlinx.coroutines.flow.Flow

interface DashboardRepository {

    fun getPointSystemsStream(): Flow<List<PointSystem>>
}