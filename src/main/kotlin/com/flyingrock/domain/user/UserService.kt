package com.flyingrock.domain.user

interface UserService {
    suspend fun registerUser(username: String, password: String)
}