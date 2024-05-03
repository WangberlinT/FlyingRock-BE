package com.flyingrock.domain.login

interface UserRepository {
    suspend fun registerUser(user: User)
}