package com.example.students.core.usecases.impl

import com.example.students.core.commands.CreateStudentCommand
import com.example.students.core.ports.CreateStudentsPort
import com.example.students.core.usecases.CreateStudentsUseCase
import org.springframework.stereotype.Component

@Component
class CreateStudentsUseCaseImpl(
   private val createStudentsPort: CreateStudentsPort
) : CreateStudentsUseCase {

    override fun execute(createStudentCommand: CreateStudentCommand) {
        createStudentsPort.create(createStudentCommand.toDomain())
    }

}