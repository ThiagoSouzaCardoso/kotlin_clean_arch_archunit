package com.example.students.gateway.entrypoints.kafka

import com.example.schema.avro.StudentMessageInput
import com.example.students.core.commands.CreateStudentCommand
import com.example.students.core.usecases.CreateStudentsUseCase
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Controller


@Controller
class StudentConsumer(
    private val createStudentsUseCase: CreateStudentsUseCase
) {

    @KafkaListener(topics = ["\${kafka.topic.student-created.name}"])
    fun listening(payload: ConsumerRecord<String, StudentMessageInput> ){

        val createStudentCommand = CreateStudentCommand(payload.value().name, payload.value().birthday)

        createStudentsUseCase.execute(createStudentCommand)

    }


}