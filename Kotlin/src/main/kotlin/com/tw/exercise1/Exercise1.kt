package main.kotlin.com.tw.exercise1

import java.util.GregorianCalendar

fun main() {
    val reese = KotlinPerson(1, "Mr", "John", "Reese", GregorianCalendar(2000, 5, 14))
    val finch = KotlinPerson(1, "Mr", "Harold", "Finch", null)
    println(reese.toString())
    println("Age is " + reese.age)
    println(finch.toString())
    println("Age is " + finch.age)
}