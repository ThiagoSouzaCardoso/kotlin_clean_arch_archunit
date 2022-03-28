package com.example.students

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class KotlinCleanArchArchunitApplication

fun main(args: Array<String>) {
    runApplication<KotlinCleanArchArchunitApplication>(*args)
}
