package com.example.adapter.driving

import com.example.port.driving.TodoApiUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.pebble.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val INDEX = "/"
private const val TODO_ID = "todoId"
private const val TODO = "/todo/${TODO_ID}"

fun Route.todoResource(useCase: TodoApiUseCase) {
    get(INDEX) {
        val todos = useCase.getTodos()
        val content = PebbleContent("index.html", mapOf("todos" to todos))
        call.respond(content)
    }

    delete(TODO) {
        val id = call.parameters[TODO_ID]?.toInt() ?: return@delete call.respond(HttpStatusCode.BadRequest)
        useCase.deleteTodo(id)
        call.respond(HttpStatusCode.OK)
    }
}