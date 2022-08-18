package com.tw.demo.todo

import org.springframework.stereotype.Service

@Service
class ToDoService {

    private var toDos = mutableListOf(
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
        toDo.forEach { toDos.add(it) }
    }

    fun updateToDo(id: String, updatedToDo: ToDo) {
        toDos.forEachIndexed { index, toDo -> if (toDo.id == id) toDos[index] = updatedToDo }
    }

    fun deleteToDo(id: String) {
        toDos.removeIf { it.id == id }
    }

}
