package com.flyingrock.domain.login

import kotlinx.serialization.SerialName

data class RegistrationResponse(
    @SerialName("message")
    val message: String,
)
