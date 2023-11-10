package com.example.adapter.driven

import com.example.domain.model.Todo
import com.example.port.driven.TodoProvider

private val testData = mutableListOf(
    Todo(id = 1, "Cleaning", "things I don't like"),
    Todo(id = 1, "Paying bills", "things I don't like"),
    Todo(id = 1, "Things", "things I don't like"),
)

class TodoTestDataAdapter : TodoProvider {

    override fun add(todo: Todo): Todo {
        testData.add(todo)
        return todo
    }

    override fun delete(id: Number) {
        testData.removeIf { it.id == id }
    }

    override fun getAll(): List<Todo> = testData
}