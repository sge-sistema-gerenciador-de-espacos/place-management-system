package com.pms.placemanagementsystemserverside.models.scheduling

import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.models.enums.SchedulingStatusEnum
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDate
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.models.user.UserModel
import javax.persistence.*

@Entity(name = "scheduling")
data class SchedulingModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var status: SchedulingStatusEnum = SchedulingStatusEnum.UNKNOWN,

        @ManyToOne(targetEntity = UserModel::class)
        var schedulerUser: UserModel = UserModel(),

        @OneToMany(targetEntity = SchedulingDate::class)
        var schedulingDates: MutableList<SchedulingDate> = mutableListOf(),

//        @Column(name = "start_date")
//        var startDate: Date = Date(),
//
//        @Column(name = "end_date")
//        var endDate: Date = Date(),

        @ManyToOne(targetEntity = UserModel::class)
        var itResponsibleUser: UserModel = UserModel(),

        @ManyToOne(targetEntity = ClazzModel::class)
        var clazz: ClazzModel = ClazzModel(),

        @ManyToOne(targetEntity = SpaceModel::class)
        var space: SpaceModel = SpaceModel()

)