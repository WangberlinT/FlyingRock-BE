package com.flyingrock.db

class UserDto(
    val username: String,
    val password: ByteArray,
    val salt: ByteArray
)
