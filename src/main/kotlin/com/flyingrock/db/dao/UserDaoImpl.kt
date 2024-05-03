package com.flyingrock.db.dao

import com.flyingrock.db.UserTable
import com.flyingrock.db.UserDto
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class UserDaoImpl : UserDao{
    override suspend fun insertUser(user: UserDto) {
        FRDatabase.dbQuery {
            UserTable.insert {
                it[username] = user.username
                it[password] = user.password
                it[salt] = user.salt
            }
        }
    }

    override suspend fun getUserByUserName(userName: String) = FRDatabase.dbQuery {
        UserTable.select { UserTable.username eq userName }
            .map { it.toUser() }
            .firstOrNull()
    }

}

private fun ResultRow.toUser() = UserDto(
    username = get(UserTable.username),
    password = get(UserTable.password),
    salt = get(UserTable.salt)
)