package com.pms.placemanagementsystemserverside.repository.course.impl

import com.pms.placemanagementsystemserverside.models.course.CourseModel
import com.pms.placemanagementsystemserverside.repository.course.CourseJpaRepository
import com.pms.placemanagementsystemserverside.repository.course.CourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
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
        if (courseJpaRepository.findById(course.id).isPresent) {
            return courseJpaRepository.saveAndFlush(course)
        }
        return CourseModel()
    }

    override fun delete(id: Long) {
        val existingCourse = courseJpaRepository.findById(id)
        courseJpaRepository.delete(existingCourse.get())
    }

}