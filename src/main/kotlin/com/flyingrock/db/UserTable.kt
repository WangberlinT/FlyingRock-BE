package com.flyingrock.db

import org.jetbrains.exposed.sql.Table

object UserTable : Table() {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 128)
    val password = binary("password", 256)
    val salt = binary("salt", 16)

    override val primaryKey = PrimaryKey(id)
}