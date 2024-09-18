package com.markgardie.gamificationtoolmobile.core

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BaseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
)