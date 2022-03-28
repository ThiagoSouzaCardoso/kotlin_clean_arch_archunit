package com.example.students.core.events

import java.time.LocalDate

data class StudentCreatedEvent(
    val name: String,
    val birthDay : LocalDate
)
