package com.pms.placemanagementsystemserverside.models.scheduling.date

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import org.joda.time.DateTime
import javax.persistence.*

@Entity(name = "scheduling_item")
data class SchedulingDateModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column(name = "start_date")
        var startTime: String = "",

        @Column(name = "end_date")
        var endTime: String = "",

        var date: String = "",

        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN
)