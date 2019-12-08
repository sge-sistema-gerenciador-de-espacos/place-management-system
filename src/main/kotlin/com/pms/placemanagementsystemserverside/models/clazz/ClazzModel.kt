package com.pms.placemanagementsystemserverside.models.clazz

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.pms.placemanagementsystemserverside.models.course.CourseModel
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.util.json.parse.clazz.ClazzDeserialize
import com.pms.placemanagementsystemserverside.util.json.parse.clazz.ClazzSerialize
import javax.persistence.*

@Entity(name = "class")
@JsonSerialize(using = ClazzSerialize::class)
@JsonDeserialize(using = ClazzDeserialize::class)
data class ClazzModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var name: String = "",

        @ManyToOne(targetEntity = CourseModel::class)
        var course: CourseModel = CourseModel(),

        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN,

        @ManyToOne
        var professor: UserModel = UserModel(),

        @ManyToMany
        @JoinTable(
                name = "student_class",
                joinColumns = [JoinColumn(name = "class_id")],
                inverseJoinColumns = [JoinColumn(name = "student_id")]
        )
        var student: UserModel = UserModel()
)