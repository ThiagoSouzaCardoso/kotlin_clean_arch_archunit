package com.example.students.gateway.dataproviders.databases.entities

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "student")
data class StudentTable(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    private val name: String,

    private val birthDay: LocalDate

)
