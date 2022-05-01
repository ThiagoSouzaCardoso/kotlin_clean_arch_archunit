package com.example.students.gateway.entrypoints.rest

import com.example.students.core.usecases.CreateStudentsUseCase
import com.example.students.gateway.entrypoints.rest.inputs.CreateStudentRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping
@RestController
class StudentsController(
    private val createStudentsUseCase: CreateStudentsUseCase
) {

    @PostMapping
    fun create(@RequestBody createStudentRequest: CreateStudentRequest){
        createStudentsUseCase.execute(createStudentRequest.toCommand())
    }

}