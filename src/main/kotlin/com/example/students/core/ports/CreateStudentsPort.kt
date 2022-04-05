package com.example.students.core.ports

import com.example.students.core.domains.Student
import com.example.students.core.events.StudentCreatedEvent

interface CreateStudentsPort {
    fun create(student: Student)
    fun publishEvent(studentCreatedEvent: StudentCreatedEvent)
}