package com.tw.demo.todo_with_in_memory_data

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.*

@ExtendWith(SpringExtension::class)
@WebMvcTest(ToDoController::class)
class ToDoControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var toDoService: ToDoService

    @Test
    fun `should get all toDos`() {
        mockMvc.get(urlTemplate = "/todos") {}.andExpect {
            status { isOk() }
            content {
                ToDoMockData.toDoList
            }
        }
    }

    @Test
    fun `should get toDo of a particular id`() {
        mockMvc.get(urlTemplate = "/todos/todo-1") {}.andExpect {
            status { isOk() }
            content {
                ToDoMockData.toDoList.data[0]
            }
        }
    }

    @Test
    fun `should create a new toDo`() {
        mockMvc.post(urlTemplate = "/todos") {
            contentType = MediaType.APPLICATION_JSON
            content = ("""
                 [
                    {
                        "id": "todo-3",
                        "title": "Vocabs",
                        "description": "Learn good vocabulary",
                        "priority": "low"
                    }
                 ]
                 """)
        }.andExpect { status { isCreated() } }
    }

    @Test
    fun `should  update an existing toDo`() {
        mockMvc.put(urlTemplate = "/todos/todo-1") {
            contentType = MediaType.APPLICATION_JSON
            content = ("""
                    {
                        "id": "todo-1",
                        "title": "Vocabs",
                        "description": "Learn good vocabulary",
                        "priority": "low"
                    }
                 """)
        }.andExpect { status { isOk() } }
    }

    @Test
    fun `should delete an existing toDo`() {
        mockMvc.delete(urlTemplate = "/todos/todo-2") {
        }.andExpect { status { isOk() } }
    }

}