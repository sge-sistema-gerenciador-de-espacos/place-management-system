package com.pms.placemanagementsystemserverside.models.scheduling

import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.models.enums.SchedulingStatusEnum
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDate
import com.pms.placemanagementsystemserverside.models.user.UserModel
import javax.persistence.*

@Entity(name = "scheduling")
data class SchedulingModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var status: SchedulingStatusEnum = SchedulingStatusEnum.UNKNOWN,

        @Column(name = "scheduler_user")
        var schedulerUser: UserModel = UserModel(),

        @Column(name = "start_date")
        var schedulingDates: List<SchedulingDate> = mutableListOf(),

//        @Column(name = "start_date")
//        var startDate: Date = Date(),
//
//        @Column(name = "end_date")
//        var endDate: Date = Date(),

        @Column(name = "IT_responsible")
        var itResponsibleUser: UserModel = UserModel(),

        @Column(name = "class_id")
        var clazz: ClazzModel = ClazzModel()

)