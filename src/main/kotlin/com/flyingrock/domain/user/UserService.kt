package com.flyingrock.domain.login

interface UserService {
    suspend fun registerUser(username: String, password: String)
}