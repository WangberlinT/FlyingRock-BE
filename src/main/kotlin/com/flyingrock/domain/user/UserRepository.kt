package com.flyingrock.domain.user

interface UserRepository {
    suspend fun registerUser(user: User)
    suspend fun isUsernameExist(username: String): Boolean
}