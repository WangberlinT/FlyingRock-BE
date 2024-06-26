package com.flyingrock.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    @SerialName("error_code")
    val errorCode: Int,
    @SerialName("message")
    val message: String?
)
