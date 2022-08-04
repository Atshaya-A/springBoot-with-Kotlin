package com.tw.demo.todo

data class ToDoResponse(val data: List<ToDo>)

data class ToDo(
    val id: String,
    val title: String,
    val description: String,
    val priority: String
)
