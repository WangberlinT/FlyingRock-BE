package com.flyingrock.domain.user

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService{
    override suspend fun registerUser(username: String, password: String) {
        if (userRepository.isUsernameExist(username)) throw UserRegisteredException()
        userRepository.registerUser(User(username, password))
    }
}