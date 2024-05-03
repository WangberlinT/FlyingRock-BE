package com.flyingrock.db.dao

import com.flyingrock.domain.user.User

interface UserDao {
    suspend fun insertUser(user: User)

    suspend fun getUserByUserName(userName: String): User?

}