package com.example.students.core.ports

import com.example.students.core.events.StudentCreatedEvent

interface PublishStudentCreatedEventPort {
    fun execute(studentCreatedEvent: StudentCreatedEvent)
}