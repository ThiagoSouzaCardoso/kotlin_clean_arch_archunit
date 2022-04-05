package com.example.students.core.ports

import com.example.students.core.events.StudentCreatedEvent

interface PublishStudentCreatedEvent {
    fun execute(studentCreatedEvent: StudentCreatedEvent)
}