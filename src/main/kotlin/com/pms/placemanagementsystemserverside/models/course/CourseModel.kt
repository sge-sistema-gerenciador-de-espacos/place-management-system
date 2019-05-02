package com.pms.placemanagementsystemserverside.models.course

import com.pms.placemanagementsystemserverside.models.program.ProgramModel
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "course")
data class CourseModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var name: String = "",

        var credit: Int = 0,

        var code: Int = 0,

        var programs: List<ProgramModel> = mutableListOf()
)