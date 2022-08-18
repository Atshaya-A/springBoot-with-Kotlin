package com.tw.demo.todo

import org.springframework.stereotype.Service

@Service
class ToDoService {

    private var toDos = listOf(
        ToDo("todo-1", "kotlin", "learn java", "high"),
        ToDo("todo-2", "spring", "learn spring framework", "low")
    )

    fun getAllToDos(): ToDoResponse {
        return ToDoResponse(toDos)
    }

    fun getToDo(id: String): ToDo {
        val foundToDo = toDos.filter { it.id == id }
        return foundToDo[0]
    }

    fun createToDo(toDo: List<ToDo>) {
        toDos = toDos + toDo
    }

}
