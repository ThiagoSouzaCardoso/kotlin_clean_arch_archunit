package com.example.students.gateway.entrypoints.rest.handles

import java.time.LocalDateTime

data class ErrorMessage(
    private  val statusCode: Int,
    private val timestamp: LocalDateTime,
    private val message: String,
    private val description: String
)
