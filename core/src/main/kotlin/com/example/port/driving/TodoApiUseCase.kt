package com.example.port.driving

import com.example.domain.model.Todo

interface TodoApiUseCase {
    fun getTodos(): List<Todo>
    fun deleteTodo(id: Number): Unit
    fun addTodo(todo: Todo): Todo
}