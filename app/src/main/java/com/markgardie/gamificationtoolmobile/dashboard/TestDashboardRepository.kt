package com.markgardie.gamificationtoolmobile.dashboard

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject


class TestDashboardRepository @Inject constructor(): DashboardRepository {
    private val testPointSystem = listOf(
        PointSystem(1, "Логіки", 0),
        PointSystem(2, "Технічні навички", 0),
        PointSystem(3, "Командна робота", 0),
        PointSystem(4, "Креативність", 0),
    )

    override fun getPointSystemsStream(): Flow<List<PointSystem>> {
        return flowOf(testPointSystem)
    }
}