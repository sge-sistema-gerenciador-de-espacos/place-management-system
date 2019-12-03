package com.pms.placemanagementsystemserverside.service.course.impl

import com.pms.placemanagementsystemserverside.models.course.CourseModel
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.repository.course.CourseRepository
import com.pms.placemanagementsystemserverside.service.course.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl : CourseService {

    @Autowired
    private lateinit var courseRepository: CourseRepository

    override fun create(courseModel: CourseModel): CourseModel {
        return courseRepository.create(courseModel)
    }

    override fun read(): List<CourseModel> {
        return courseRepository.read()
    }

    override fun readActive(): List<CourseModel> {
        return read().filter { it.status == ActivationModelStatusEnum.ACTIVE }
    }

    override fun update(courseModel: CourseModel) {
        courseRepository.update(courseModel)
    }

    override fun delete(id: Long) {
        courseRepository.delete(id)
    }
}