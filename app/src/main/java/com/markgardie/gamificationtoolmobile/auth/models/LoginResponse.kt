package com.markgardie.gamificationtoolmobile.auth.models

import kotlinx.serialization.SerialName

data class LoginResponse(
    @SerialName("token") val token: String
)
