package com.markgardie.gamificationtoolmobile.core.models

import kotlinx.serialization.Serializable

@Serializable
sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val message: String) : NetworkResult<Nothing>()
}