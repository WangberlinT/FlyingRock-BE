package com.flyingrock.plugins

import com.flyingrock.domain.InternalException
import com.flyingrock.domain.toResponseBody
import com.flyingrock.domain.user.LoginRequest
import com.flyingrock.domain.user.RegistrationRequest
import com.flyingrock.domain.user.RegistrationResponse
import com.flyingrock.domain.user.UserService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
fun Application.configureRouting() {
    val userService: UserService by inject()

    routing {
        get("/") {
            call.respondText("Hello world")
        }
        post("/login") {
            val request = call.receive<LoginRequest>()
            userService.login(request.username, request.password)
            call.respond(HttpStatusCode.OK)
        }
        post("/register") {
            val request = call.receive<RegistrationRequest>()
            userService.registerUser(request.username, request.password)
            call.respond(HttpStatusCode.Created, RegistrationResponse("user ${request.username} created").toResponseBody())
        }
        get("/error") {
            throw InternalException(errorCode = 0)
        }
    }
}
