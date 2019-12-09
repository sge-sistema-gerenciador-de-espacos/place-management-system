package com.pms.placemanagementsystemserverside.models.scheduling

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.models.enums.SchedulingStatusEnum
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDateModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.util.json.parse.scheduling.SchedulingDeserialize
import com.pms.placemanagementsystemserverside.util.json.parse.scheduling.SchedulingSerialize
import javax.persistence.*

@Entity(name = "scheduling")
@JsonSerialize(using = SchedulingSerialize::class)
@JsonDeserialize(using = SchedulingDeserialize::class)
data class SchedulingModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var status: SchedulingStatusEnum = SchedulingStatusEnum.UNKNOWN,

        @ManyToOne(targetEntity = UserModel::class)
        @Column(name = "scheduler_user")
        var schedulerUser: UserModel = UserModel(),

        @OneToMany(targetEntity = SchedulingDateModel::class)
        var schedulingDateModels: MutableList<SchedulingDateModel> = mutableListOf(),

        @ManyToOne(targetEntity = UserModel::class)
        @Column(name = "it_responsible")
        var itResponsible: UserModel = UserModel(),

        @Column(name = "it_responsible_msg")
        var itResponsibleMsg: String = "",

        @ManyToOne(targetEntity = ClazzModel::class)
        @Column(name = "class_id")
        var clazz: ClazzModel = ClazzModel(),

        @ManyToOne(targetEntity = UserModel::class)
        @JoinColumn(name = "assistent_acceptor_id")
        var assistent: UserModel = UserModel(),

        var assistentMsg: String = "",

        var professor: UserModel = UserModel(),

        var spaceIntention: SpaceModel = SpaceModel()
)