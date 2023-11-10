package com.example.service

import com.example.domain.model.Todo
import com.example.port.driven.TodoProvider
import com.example.port.driving.TodoApiUseCase

class TodoService(
    private val todoPersistencePort: TodoProvider
) : TodoApiUseCase {

    override fun getTodos(): List<Todo> = todoPersistencePort.getAll()

    override fun deleteTodo(id: Number) {
        todoPersistencePort.delete(id)
    }

    override fun addTodo(todo: Todo): Todo = todoPersistencePort.add(todo)
}