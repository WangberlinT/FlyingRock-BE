package com.flyingrock.domain.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class LoginRequest(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String
)
