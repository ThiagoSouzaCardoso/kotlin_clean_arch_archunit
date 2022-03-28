package com.example.students.gateway.entrypoints.rest.inputs

import com.example.students.core.commands.CreateStudentCommand
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class CreateStudentRequest(
    val name: String,

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    val birthDay: LocalDate
)

{
    fun toCommand() = CreateStudentCommand(name,birthDay)


}
