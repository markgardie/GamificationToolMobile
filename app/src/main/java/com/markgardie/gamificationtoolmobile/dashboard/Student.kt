package com.markgardie.gamificationtoolmobile.dashboard

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val age: Int,
    val group: String,
)