package com.example.students.core.usecases

import com.example.students.core.commands.CreateStudentCommand
import com.example.students.core.ports.CreateStudentsPort

class CreateStudentsUseCase(
   private val createStudentsPort: CreateStudentsPort
)  {

    fun execute(createStudentCommand: CreateStudentCommand) {
        createStudentsPort.create(createStudentCommand.toDomain())
    }

}