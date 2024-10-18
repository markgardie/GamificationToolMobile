package com.markgardie.gamificationtoolmobile.dashboard

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "point_systems")
data class PointSystem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val value: Int,
)