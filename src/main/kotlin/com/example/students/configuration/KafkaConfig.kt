package com.example.students.configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.TopicBuilder



@EnableKafka
@Configuration
class KafkaConfig {

    @Bean
    fun studentCreatedTopic(
        @Value("\${kafka.topic.student-created.name}") topicName : String,
        @Value("\${kafka.topic.student-created.partitions}") partitions : Int,
        @Value("\${kafka.topic.student-created.replicas}") replicas : Int
    ) : NewTopic {
        return TopicBuilder.name(topicName)
            .partitions(partitions)
            .replicas(replicas)
            .build()
    }

    @Bean
    fun studentCourseCreatedTopic(
        @Value("\${kafka.topic.student-course-created.name}") topicName : String,
        @Value("\${kafka.topic.student-course-created.partitions}") partitions : Int,
        @Value("\${kafka.topic.student-course-created.replicas}") replicas : Int
    ) : NewTopic {
        return TopicBuilder.name(topicName)
            .partitions(partitions)
            .replicas(replicas)
            .build()
    }

}