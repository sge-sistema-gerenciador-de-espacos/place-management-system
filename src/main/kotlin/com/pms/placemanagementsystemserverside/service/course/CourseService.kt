package com.pms.placemanagementsystemserverside.service.course

import com.pms.placemanagementsystemserverside.models.course.CourseModel

interface CourseService {
    fun create(courseModel: CourseModel): CourseModel
    fun read(): List<CourseModel>
    fun update(courseModel: CourseModel)
    fun delete(id: Long)
}