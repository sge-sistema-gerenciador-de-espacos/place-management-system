package com.pms.placemanagementsystemserverside.models.clazz

import com.pms.placemanagementsystemserverside.models.course.CourseModel
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "class")
data class ClazzModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var name: String = "",

        var courseModel: CourseModel = CourseModel()
)