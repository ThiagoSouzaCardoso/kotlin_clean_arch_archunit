package com.example.students.gateway.dataproviders.databases.entities

import com.example.students.core.domains.Student
import io.micrometer.core.lang.NonNull
import java.time.LocalDate
import javax.persistence.*


@Entity
@Table
data class StudentTable(

    @Id
    @GeneratedValue
    private val id: Long? = null,

    private val name: String,

    @Temporal(TemporalType.DATE)
    private val birthDay: LocalDate

)
