package com.flyingrock.plugins

import com.flyingrock.di.appModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.installKoin() {
    install(Koin) {
        modules(appModule)
    }
}
