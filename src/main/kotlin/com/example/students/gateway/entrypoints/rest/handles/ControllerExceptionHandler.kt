package com.example.students.gateway.entrypoints.rest.handles

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun globalExceptionHandler(ex: Exception, request: WebRequest): ResponseEntity<ErrorMessage> {
        val message = ex.message?.let {
            ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                it,
                request.getDescription(false)
            )
        }
        return ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR)
    }


}