package com.markgardie.gamificationtoolmobile.dashboard.model

import com.markgardie.gamificationtoolmobile.core.util.LocalDateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class StudentResponse(
    @SerialName("name") val name: String,
    @Serializable(with = LocalDateSerializer::class)
    @SerialName("birthDate") val birthDate: LocalDate,
    @SerialName("group") val group: String,
    @SerialName("pointSystems") val pointSystems: Map<String, Int>
)
