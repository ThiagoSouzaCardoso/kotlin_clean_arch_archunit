package com.example.students.core.ports

import com.example.students.core.domains.Student

interface CreateStudentsPort {
    fun create(student: Student)
}