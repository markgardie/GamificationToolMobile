package com.markgardie.gamificationtoolmobile.dashboard

import kotlinx.serialization.SerialName

data class StudentResponse(
    @SerialName("name") val name: String,
    @SerialName("age") val age: Int,
    @SerialName("group") val group: String,
    @SerialName("pointSystems") val pointSystems: Map<String, Int>
)
