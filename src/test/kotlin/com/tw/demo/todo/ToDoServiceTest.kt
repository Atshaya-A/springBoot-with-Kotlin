package com.tw.demo.todo

import io.mockk.spyk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ToDoServiceTest {

    private val toDoService = spyk(ToDoService())

    @Test
    fun `should get all toDos when getAllToDosAPI is called`() {
        val toDoData = ToDoMockData.toDoList

        val toDoList = toDoService.getAllToDos()

        assertEquals(2, toDoList.data.size)
        assertEquals(toDoData, toDoList)
    }

    @Test
    fun `should get toDo of a given id when getToDoAPI is called`() {
        val toDoData = ToDoMockData.toDoList.data[0]
        val mockToDoId = toDoData.id

        val toDoOfGivenId = toDoService.getToDo(mockToDoId)

        assertEquals(toDoData, toDoOfGivenId)
    }

    @Test
    fun `should create a new toDo when create toDo API is called`() {
        val toDoToBeCreated = ToDo("todo-5", "test", "test", "high")

        toDoService.createToDo(listOf(toDoToBeCreated))
        val toDoList = toDoService.getAllToDos()

        assertEquals(3, toDoList.data.size)
        assertEquals(ToDoMockData.toDoList.data + listOf(toDoToBeCreated), toDoList.data)
    }
}
