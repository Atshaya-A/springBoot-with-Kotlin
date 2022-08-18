package com.tw.demo.todo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ToDoController(val toDoService: ToDoService) {

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    fun getAllToDos(): ToDoResponse {
        return toDoService.getAllToDos()
    }

    @GetMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getToDo(@PathVariable id: String): ToDo {
        return toDoService.getToDo(id)
    }

    @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    fun createToDo(@RequestBody toDo : List<ToDo>) {
        toDoService.createToDo(toDo)
    }

}
