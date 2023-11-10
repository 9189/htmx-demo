package com.example

import com.example.adapter.driven.TodoTestDataAdapter
import com.example.adapter.driving.todoResource
import com.example.configuration.*
import com.example.service.TodoService
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configuration()

    val provider = TodoTestDataAdapter()
    val todoApiUseCase = TodoService(provider)

    routing {
        todoResource(todoApiUseCase)
    }
}
