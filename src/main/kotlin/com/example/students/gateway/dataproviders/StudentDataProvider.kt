package com.example.students.gateway.dataproviders

import com.example.students.core.domains.Student
import com.example.students.core.events.StudentCreatedEvent
import com.example.students.core.ports.CreateStudentsPort
import com.example.students.gateway.dataproviders.databases.entities.StudentTable
import com.example.students.gateway.dataproviders.databases.repositories.StudentRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class StudentDataProvider(
    private val studentRepository: StudentRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) : CreateStudentsPort {

    override fun create(student: Student) {
        val studentTable = StudentTable(null, student.name, student.birthDay)
        studentRepository.save(studentTable)
    }

    override fun publishEvent(studentCreatedEvent: StudentCreatedEvent) {
        applicationEventPublisher.publishEvent(studentCreatedEvent)
    }
}