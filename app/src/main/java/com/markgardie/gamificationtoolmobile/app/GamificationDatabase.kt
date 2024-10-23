package com.markgardie.gamificationtoolmobile.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.markgardie.gamificationtoolmobile.dashboard.Student
import com.markgardie.gamificationtoolmobile.dashboard.PointSystem

@Database(
    entities = [PointSystem::class, Student::class],
    version = 1
)
abstract class GamificationDatabase : RoomDatabase() {
}