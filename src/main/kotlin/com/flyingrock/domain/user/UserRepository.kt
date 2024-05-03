package com.flyingrock.domain.user

import com.flyingrock.db.UserDto

interface UserRepository {
    suspend fun registerUser(username: String, password: String)

    suspend fun login(username: String, password: String): UserDto
    suspend fun isUsernameExist(username: String): Boolean
}