package com.tw.demo.todo

object ToDoMockData {

    val toDoList = ToDoResponse(
        data = listOf(
            ToDo(
                id = "todo-1",
                title = "Learn spring boot",
                description = "Learn spring boot basics",
                priority = "high"
            ),
            ToDo(
                id = "todo-2",
                title = "Learn spring",
                description = "Learn spring framework basics",
                priority = "low"
            )
        )
    )

}
