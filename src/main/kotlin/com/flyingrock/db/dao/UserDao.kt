package com.flyingrock.db.dao

import com.flyingrock.db.UserDto

interface UserDao {
    suspend fun insertUser(user: UserDto)

    suspend fun getUserByUserName(userName: String): UserDto?

}