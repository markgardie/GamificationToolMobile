package com.markgardie.gamificationtoolmobile.app.di

import com.markgardie.gamificationtoolmobile.dashboard.DashboardRepository
import com.markgardie.gamificationtoolmobile.dashboard.TestDashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TestRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @TestRepository
    @Binds
    fun bindTestDashboardRepository(impl: TestDashboardRepository): DashboardRepository
}