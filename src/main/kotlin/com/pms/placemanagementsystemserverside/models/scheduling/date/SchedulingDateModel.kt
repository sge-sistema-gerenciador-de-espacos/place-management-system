package com.pms.placemanagementsystemserverside.models.scheduling.date

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import org.joda.time.DateTime
import javax.persistence.*

@Entity(name = "scheduling_item")
data class SchedulingDateModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column(name = "start_date")
        var startTime: DateTime = DateTime(),

        @Column(name = "end_date")
        var endTime: DateTime = DateTime(),

        //TODO criar no banco
        var date: DateTime = DateTime(),

        @ManyToOne(targetEntity = SpaceModel::class)
        var space: SpaceModel = SpaceModel(),

        @ManyToOne
        var schedulingDateModel: SchedulingModel = SchedulingModel(),

        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN
)