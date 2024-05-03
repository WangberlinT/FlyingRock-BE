package com.flyingrock

import com.flyingrock.db.dao.FRDatabase
import com.flyingrock.di.appModule
import com.flyingrock.plugins.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
    embeddedServer(
        Netty,
    ) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    FRDatabase.init()
    install(Koin) {
        modules(appModule)
    }
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
    configureRouting()
}
