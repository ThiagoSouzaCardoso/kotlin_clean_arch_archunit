package com.example.students.configuration

import com.example.students.core.ports.CreateStudentsPort
import com.example.students.core.usecases.CreateStudentsUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {

    @Bean
    fun instanceOfCreateStudent(createStudentsPort: CreateStudentsPort): CreateStudentsUseCase {
        return CreateStudentsUseCase(createStudentsPort)
    }

}