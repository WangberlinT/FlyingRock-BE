package com.flyingrock.db

import org.jetbrains.exposed.sql.Table

object User : Table() {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 128)
    val password = varchar("password", 1024)

    override val primaryKey = PrimaryKey(id)
}