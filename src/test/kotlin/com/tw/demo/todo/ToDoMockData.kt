package com.tw.demo.todo

object ToDoMockData {

    val toDoList = ToDoResponse(
        data = listOf(
            ToDo("todo-1", "kotlin", "learn java", "high"),
            ToDo("todo-2", "spring", "learn spring framework", "low")
        )
    )

}
