package com.example.configuration

import io.ktor.server.application.*
import io.ktor.server.pebble.*
import io.pebbletemplates.pebble.loader.ClasspathLoader

fun Application.configuration() {
    install(Pebble) {
        loader(ClasspathLoader().apply {
            prefix = "templates"
        })
    }
}