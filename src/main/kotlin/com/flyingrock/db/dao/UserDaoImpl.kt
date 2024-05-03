package com.flyingrock.db.dao

import com.flyingrock.db.UserTable
import com.flyingrock.domain.user.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class UserDaoImpl : UserDao{
    override suspend fun insertUser(user: User) {
        FRDatabase.dbQuery {
            UserTable.insert {
                it[username] = user.username
                it[password] = user.password
            }
        }
    }

    override suspend fun getUserByUserName(userName: String) = FRDatabase.dbQuery {
        UserTable.select { UserTable.username eq userName }
            .map { it.toUser() }
            .firstOrNull()
    }

}

private fun ResultRow.toUser() = User(
    username = get(UserTable.username),
    password = get(UserTable.password)
)