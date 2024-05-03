package com.flyingrock.db

import com.flyingrock.db.dao.UserDao
import com.flyingrock.domain.user.User
import com.flyingrock.domain.user.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository{
    override suspend fun registerUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun isUsernameExist(username: String): Boolean {
        return userDao.getUserByUserName(username) != null
    }
}