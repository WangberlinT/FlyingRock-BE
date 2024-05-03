package com.flyingrock.domain

import kotlinx.serialization.*

@Serializable
data class ResponseBody<T> (
    @SerialName("data")
    val data: T
)