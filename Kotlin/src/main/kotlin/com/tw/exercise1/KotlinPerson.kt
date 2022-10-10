package main.kotlin.com.tw.exercise1

import java.util.Calendar
import java.util.GregorianCalendar

class KotlinPerson(val id: Long, private val title: String, private val firstName: String, private val surName: String, private val dateOfBirth: Calendar?) {

    override fun toString(): String {
        return "$title $firstName $surName"
    }

    val age: Int
        get() = getAge(dateOfBirth)


    companion object {
        fun getAge(dateOfBirth: Calendar?): Int {
            if (dateOfBirth == null) {
                return -1
            }
            val today = GregorianCalendar()
            val years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
            return if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)){
                years-1
            }else{
                years
            }
        }
    }

}