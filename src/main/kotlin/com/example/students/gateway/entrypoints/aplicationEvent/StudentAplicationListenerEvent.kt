package com.example.students.gateway.entrypoints.aplicationEvent

import com.example.students.core.events.StudentCreatedEvent
import com.example.students.core.ports.PublishStudentCreatedEventPort
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Controller

@Controller
class StudentAplicationListenerEvent(
    private val publishStudentCreatedEventPort: PublishStudentCreatedEventPort

) {

    @EventListener
    fun handleStudentCreatedEvent(studentCreatedEvent: StudentCreatedEvent){
        publishStudentCreatedEventPort.execute(studentCreatedEvent)
    }


}