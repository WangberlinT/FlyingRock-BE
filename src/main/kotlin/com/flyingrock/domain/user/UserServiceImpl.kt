package com.flyingrock.domain.user

import com.flyingrock.PasswordUtils
import com.flyingrock.db.UserDto

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService{
    override suspend fun registerUser(username: String, password: String) {
        if (userRepository.isUsernameExist(username)) throw UserRegisteredException()
        userRepository.registerUser(username, password)
    }

    override suspend fun login(username: String, password: String) {
        userRepository.login(username, password)
    }
}