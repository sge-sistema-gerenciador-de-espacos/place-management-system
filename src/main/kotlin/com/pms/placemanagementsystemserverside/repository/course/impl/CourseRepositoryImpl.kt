package com.pms.placemanagementsystemserverside.repository.course.impl

import com.pms.placemanagementsystemserverside.models.course.CourseModel
import com.pms.placemanagementsystemserverside.repository.course.CourseJpaRepository
import com.pms.placemanagementsystemserverside.repository.course.CourseRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired

class CourseRepositoryImpl : CourseRepository {

    @Autowired
    private lateinit var courseJpaRepository: CourseJpaRepository

    override fun create(course: CourseModel): CourseModel {
        return courseJpaRepository.saveAndFlush(course)
    }

    override fun read(): List<CourseModel> {
        return courseJpaRepository.findAll()
    }

    override fun update(course: CourseModel): CourseModel {
        val existingCourse = courseJpaRepository.findById(course.id)
        BeanUtils.copyProperties(course, existingCourse)
        return courseJpaRepository.saveAndFlush(existingCourse.get())
    }

    override fun delete(id: Long) {
        val existingCourse = courseJpaRepository.findById(id)
        courseJpaRepository.delete(existingCourse.get())
    }

}