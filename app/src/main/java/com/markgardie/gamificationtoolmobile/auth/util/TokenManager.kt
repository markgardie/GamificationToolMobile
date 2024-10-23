package com.markgardie.gamificationtoolmobile.auth.util

object TokenManager {

    private var token: String? = null

    fun saveToken(newToken: String) {
        token = newToken
    }

    fun getToken(): String? = token
}