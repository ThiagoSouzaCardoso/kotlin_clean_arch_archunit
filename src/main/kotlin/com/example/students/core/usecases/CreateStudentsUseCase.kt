package com.example.students.core.usecases

import com.example.students.core.commands.CreateStudentCommand

interface CreateStudentsUseCase {
    fun execute(createStudentCommand: CreateStudentCommand)
}