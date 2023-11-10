package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.pebble.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.routing() {
    routing {
        get("/") {
            val sampleUser = PebbleUser(1, "Test")
            call.respond(PebbleContent("index.html", mapOf("user" to sampleUser)))
        }
    }
}

data class PebbleUser(val id: Int, val name: String)