package com.example.students.core.commands

import com.example.students.core.domains.Student
import java.time.LocalDate

data class CreateStudentCommand(
    val name: String,
    val birthDay : LocalDate
) {
   fun toDomain() : Student {
     return Student(name, birthDay)
   }


}