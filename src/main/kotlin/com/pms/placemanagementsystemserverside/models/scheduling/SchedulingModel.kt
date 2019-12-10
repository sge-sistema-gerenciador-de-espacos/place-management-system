package com.pms.placemanagementsystemserverside.models.scheduling

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.models.enums.SchedulingStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDateModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
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
        var schedulerUser: UserModel = UserModel(),

        @OneToMany(targetEntity = SchedulingDateModel::class)
        var schedulingDateModels: MutableList<SchedulingDateModel> = mutableListOf(),

        @ManyToOne(targetEntity = UserModel::class)
        var itResponsible: UserModel = UserModel(),

        @Column(name = "it_responsible_msg")
        var itResponsibleMsg: String = "",

        @ManyToOne(targetEntity = ClazzModel::class)
        var clazz: ClazzModel = ClazzModel(),

        @ManyToOne(targetEntity = UserModel::class)
        var assistent: UserModel = UserModel(),

        var assistentMsg: String = "",

        @ManyToOne
        var professor: UserModel = UserModel(),


        // ============ space intention ==========

        //TODO fazer o space item

        var numberOfChairs: Int = 0,

        @Column(name = "projector")
        var hasProjector: Boolean = false,

        @Column(name = "board")
        var hasBoard: Boolean = false,

        @Column(name = "smart_board")
        var hasSmartBoard: Boolean = false,

        var spaceType: SpaceTypeEnum = SpaceTypeEnum.UNKNOWN,

        @Column(name = "number_pc")
        var numberOfPcs: Int = 0,

        @ManyToMany(targetEntity = SoftwareModel::class)
        var softwares: List<SoftwareModel> = mutableListOf(),

        @ManyToOne(targetEntity = SpaceModel::class)
        var spaceFound: SpaceModel = SpaceModel()
) {

    fun getSpaceIntention() = SpaceModel(
            numberOfChairs = numberOfChairs, hasProjector = hasProjector, hasBoard = hasBoard,
            hasSmartBoard = hasSmartBoard, type = spaceType, numberOfPcs = numberOfPcs, softwares = softwares
    )
}