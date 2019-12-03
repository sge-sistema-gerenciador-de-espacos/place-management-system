package com.pms.placemanagementsystemserverside.models.course

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.program.ProgramModel
import com.pms.placemanagementsystemserverside.util.json.parse.course.CourseDeserialize
import com.pms.placemanagementsystemserverside.util.json.parse.course.CourseSerialize
import javax.persistence.*

@Entity(name = "course")
@JsonSerialize(using = CourseSerialize::class)
@JsonDeserialize(using = CourseDeserialize::class)
data class CourseModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var name: String = "",

        var credit: Int = 0,

        var period: Int = 0,

        var code: String = "",

        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN,

        @OneToOne(targetEntity = ProgramModel::class)
        var program: ProgramModel = ProgramModel()
) {
    companion object {
        val ANNUAL_PERIOD = 100
    }
}