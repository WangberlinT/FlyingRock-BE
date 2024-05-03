package com.flyingrock.plugins

import com.flyingrock.domain.ErrorResponse
import com.flyingrock.domain.InternalException
import com.flyingrock.domain.user.UserException
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.installStatusPages() {
    install(StatusPages) {
        exception<InternalException> { call, cause ->
            call.respond(
                ErrorResponse(
                    errorCode = cause.errorCode,
                    message = cause.message
                )
            )
        }
        exception<UserException> { call, cause ->
            call.respond(
                ErrorResponse(
                    errorCode = cause.errorCode,
                    message = cause.message
                )
            )
        }
    }
}