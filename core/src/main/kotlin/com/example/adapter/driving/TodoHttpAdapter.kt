package com.example.adapter.driving

import com.example.port.driving.TodoApiUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.pebble.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val INDEX_ROUTE = "/"
private const val TODO_ID = "todoId"
private const val TODO_ROUTE = "/todo"
private const val TODO_BY_ID_ROUTE = "${TODO_ROUTE}/{${TODO_ID}}"

fun Route.todoResource(useCase: TodoApiUseCase) {

    get(INDEX_ROUTE) {
        val todos = useCase.getTodos()
        val content = PebbleContent("index.html", mapOf("todos" to todos))
        call.respond(content)
    }

    post(TODO_ROUTE) {

    }

    delete(TODO_BY_ID_ROUTE) {
        val id = call.parameters[TODO_ID]?.toInt() ?: return@delete call.respond(HttpStatusCode.BadRequest)
        useCase.deleteTodo(id)
        call.respond(HttpStatusCode.OK)
    }
}