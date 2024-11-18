package com.markgardie.gamificationtoolmobile.app.di

import com.markgardie.gamificationtoolmobile.auth.repository.AuthRepository
import com.markgardie.gamificationtoolmobile.auth.repository.NetworkAuthRepository
import com.markgardie.gamificationtoolmobile.dashboard.repository.DashboardRepository
import com.markgardie.gamificationtoolmobile.dashboard.repository.NetworkStudentRepository
import com.markgardie.gamificationtoolmobile.dashboard.repository.StudentRepository
import com.markgardie.gamificationtoolmobile.dashboard.repository.TestDashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TestRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @TestRepository
    @Binds
    fun bindTestDashboardRepository(impl: TestDashboardRepository): DashboardRepository

    @Binds
    @Singleton
    fun bindStudentRepository(
        networkStudentRepository: NetworkStudentRepository
    ): StudentRepository

    @Binds
    fun bindNetworkAuthRepository(impl: NetworkAuthRepository): AuthRepository
}