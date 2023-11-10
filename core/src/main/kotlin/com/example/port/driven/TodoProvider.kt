package com.example.port.driven

import com.example.domain.model.Todo

interface TodoProvider {
    fun add(todo: Todo): Todo
    fun delete(id: Number)
    fun getAll(): List<Todo>
}