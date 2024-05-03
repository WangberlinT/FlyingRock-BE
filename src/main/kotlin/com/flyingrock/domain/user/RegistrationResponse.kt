package com.flyingrock.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationResponse(
    @SerialName("message")
    val message: String,
)
