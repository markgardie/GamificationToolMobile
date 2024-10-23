package com.markgardie.gamificationtoolmobile.auth.model

import kotlinx.serialization.SerialName

data class LoginRequest(
    @SerialName("login") val login: String,
    @SerialName("password") val password: String
)
