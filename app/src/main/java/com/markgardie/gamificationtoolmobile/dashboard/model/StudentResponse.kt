package com.markgardie.gamificationtoolmobile.dashboard.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StudentResponse(
    @SerialName("name") val name: String,
    @SerialName("age") val age: Int,
    @SerialName("group") val group: String,
    @SerialName("pointSystems") val pointSystems: Map<String, Int>
)
