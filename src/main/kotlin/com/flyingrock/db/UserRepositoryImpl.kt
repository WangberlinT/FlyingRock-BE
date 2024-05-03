package com.flyingrock.db

import com.flyingrock.PasswordUtils
import com.flyingrock.db.dao.UserDao
import com.flyingrock.domain.user.UserNotExistException
import com.flyingrock.domain.user.UserRepository
import com.flyingrock.domain.user.WrongPasswordException

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository{
    override suspend fun registerUser(username: String, password: String) {
        val salt = PasswordUtils.generateSalt()
        val hashPassword = PasswordUtils.hash(password, salt)
        userDao.insertUser(UserDto(username, hashPassword, salt))
    }

    override suspend fun login(username: String, password: String): UserDto {
        val user = userDao.getUserByUserName(username) ?: throw UserNotExistException()
        if (!PasswordUtils.isExpectedPassword(password, user.salt, user.password)) throw WrongPasswordException()
        return user
    }

    override suspend fun isUsernameExist(username: String): Boolean {
        return userDao.getUserByUserName(username) != null
    }
}