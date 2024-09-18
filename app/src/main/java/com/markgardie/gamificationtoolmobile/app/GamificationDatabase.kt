package com.markgardie.gamificationtoolmobile.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.markgardie.gamificationtoolmobile.core.BaseEntity

@Database(
    entities = [BaseEntity::class],
    version = 1
)
abstract class GamificationDatabase : RoomDatabase() {
}