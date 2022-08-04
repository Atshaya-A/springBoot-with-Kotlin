package com.tw.demo.todo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ToDoController(val toDoService: ToDoService) {

    @GetMapping("/toDos")
    fun getAllToDos(): ToDoResponse {
        return toDoService.getAllToDos()
    }

    @GetMapping("/toDos/{id}")
    fun getToDo(@PathVariable id: String): ToDo {
        return toDoService.getToDo(id)
    }

}
