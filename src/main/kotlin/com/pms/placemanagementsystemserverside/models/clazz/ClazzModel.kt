package com.pms.placemanagementsystemserverside.models.clazz

import com.pms.placemanagementsystemserverside.models.course.CourseModel
import javax.persistence.*

@Entity(name = "class")
data class ClazzModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var name: String = "",

        @ManyToOne(targetEntity = CourseModel::class)
        var courseModel: CourseModel = CourseModel()
)