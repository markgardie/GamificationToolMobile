package com.markgardie.gamificationtoolmobile.auth.model

import kotlinx.serialization.SerialName

data class LoginResponse(
    @SerialName("token") val token: String
)
