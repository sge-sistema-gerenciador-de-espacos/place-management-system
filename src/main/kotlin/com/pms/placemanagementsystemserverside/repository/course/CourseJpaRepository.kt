package com.pms.placemanagementsystemserverside.repository.course

import com.pms.placemanagementsystemserverside.models.course.CourseModel
import org.springframework.data.jpa.repository.JpaRepository

interface CourseJpaRepository : JpaRepository<CourseModel, Long> {
}