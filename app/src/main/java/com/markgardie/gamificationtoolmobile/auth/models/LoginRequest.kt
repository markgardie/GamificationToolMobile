package com.markgardie.gamificationtoolmobile.auth.models

import kotlinx.serialization.SerialName

data class LoginRequest(
    @SerialName("login") val login: String,
    @SerialName("password") val password: String
)
