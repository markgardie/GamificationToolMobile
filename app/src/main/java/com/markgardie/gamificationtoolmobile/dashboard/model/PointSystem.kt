package com.markgardie.gamificationtoolmobile.dashboard.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "point_systems")
data class PointSystem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val value: Int,
)