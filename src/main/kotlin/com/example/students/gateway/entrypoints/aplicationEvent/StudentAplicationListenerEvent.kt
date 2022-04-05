package com.example.students.gateway.entrypoints.aplicationEvent

import com.example.students.core.events.StudentCreatedEvent
import com.example.students.core.ports.PublishStudentCreatedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Controller

@Controller
class StudentAplicationListenerEvent(
    private val publishStudentCreatedEvent: PublishStudentCreatedEvent

) {

    @EventListener
    fun handleStudentCreatedEvent(studentCreatedEvent: StudentCreatedEvent){
        publishStudentCreatedEvent.execute(studentCreatedEvent)
    }


}