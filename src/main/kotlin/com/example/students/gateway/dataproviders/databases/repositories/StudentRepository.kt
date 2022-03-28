package com.example.students.gateway.dataproviders.databases.repositories

import com.example.students.gateway.dataproviders.databases.entities.StudentTable
import org.springframework.data.repository.PagingAndSortingRepository

interface StudentRepository : PagingAndSortingRepository<StudentTable, Long> {
}