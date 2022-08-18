package com.tw.demo.todo_with_in_memory_data

data class ToDoResponse(val data: List<ToDo>)

data class ToDo(
    val id: String,
    val title: String,
    val description: String,
    val priority: String
)
