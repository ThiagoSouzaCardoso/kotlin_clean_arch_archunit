package com.example.students.gateway.dataproviders.kafka

import com.example.students.core.events.StudentCreatedEvent
import com.example.students.core.ports.PublishStudentCreatedEventPort
import io.confluent.developer.StudentMessageInput
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFutureCallback


@Component
class PublishKafkaStudentCreatedEvent(
    private val kafkaTemplate: KafkaTemplate<String, StudentMessageInput>,
    @Value("\${kafka.topic.student-course-created.name}")
    private val topicName: String
) : PublishStudentCreatedEventPort {


    override fun execute(studentCreatedEvent: StudentCreatedEvent) {
        val message =
            StudentMessageInput.newBuilder().setName(studentCreatedEvent.name).setBirthday(studentCreatedEvent.birthDay)
                .build()

        val future = kafkaTemplate.send(topicName, message)

        future.addCallback(object : ListenableFutureCallback<SendResult<String, StudentMessageInput>>
            {
                override fun onSuccess(result: SendResult<String, StudentMessageInput>?) {
                    println("enviou")
                    println(result)
                }

                override fun onFailure(ex: Throwable) {
                    println("nao enviou")
                    println(ex)
                }
            }
        )





    }
}