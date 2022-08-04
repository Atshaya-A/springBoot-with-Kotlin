package com.tw.demo.todo

import io.mockk.every
import io.mockk.spyk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ToDoServiceTest {

    private val toDoService = spyk(ToDoService())

    @Test
    fun `should get all toDos when getAllToDosAPI is called`() {
        val toDoMockData = ToDoMockData.toDoList.data
        every { toDoService.getAllToDos() } returns ToDoMockData.toDoList

        val toDoList = toDoService.getAllToDos()

        assertEquals(2, toDoList.data.size)
        assertEquals(toDoMockData, toDoList.data)
    }

    @Test
    fun `should get toDos for given id when getToDoAPI is called`() {
        val toDoMockData = ToDoMockData.toDoList.data[0]
        val mockToDoId = toDoMockData.id
        every { toDoService.getToDo(mockToDoId) } returns toDoMockData

        val toDoOfGivenId = toDoService.getToDo(mockToDoId)

        assertEquals(toDoMockData, toDoOfGivenId)
    }

}
