package com.pms.placemanagementsystemserverside.repository.course

import com.pms.placemanagementsystemserverside.models.course.CourseModel

interface CourseRepository {
    fun create(course: CourseModel): CourseModel
    fun read(): List<CourseModel>
    fun update(course: CourseModel): CourseModel
    fun delete(id: Long)
}