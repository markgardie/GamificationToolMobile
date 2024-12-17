package com.markgardie.gamificationtoolmobile.app

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.markgardie.gamificationtoolmobile.core.util.LocalDateConverter
import com.markgardie.gamificationtoolmobile.dashboard.model.PointSystem
import com.markgardie.gamificationtoolmobile.dashboard.model.Student

@Database(
    entities = [PointSystem::class, Student::class],
    version = 1
)
@TypeConverters(LocalDateConverter::class)
abstract class GamificationDatabase : RoomDatabase() {
}