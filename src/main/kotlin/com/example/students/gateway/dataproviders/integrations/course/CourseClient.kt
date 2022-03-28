package com.example.students.gateway.dataproviders.integrations.course

import com.example.students.gateway.dataproviders.integrations.course.outputs.GetCourseResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "course", url = "http://localhost:8080/courses")
interface CourseClient  {

    @RequestMapping(method = [RequestMethod.GET], value = ["/"])
    fun getCourses(): GetCourseResponse


}