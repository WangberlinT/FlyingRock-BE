package com.flyingrock.domain.login

class UserServiceImpl(
    private val checkUserExistUseCase: CheckUserExistUseCase,
    private val userRepository: UserRepository
) : UserService{
    override suspend fun registerUser(username: String, password: String) {
        if (checkUserExistUseCase.isUsernameExist(username)) throw UserRegisteredException()
        userRepository.registerUser(User(username, password))
    }
}