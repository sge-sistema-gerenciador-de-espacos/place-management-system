package com.pms.placemanagementsystemserverside.models.scheduling.date

import java.util.*
import javax.persistence.*

@Entity(name = "scheduling_date")
data class SchedulingDateModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column(name = "start_date")
        var startDate: Date = Date(),

        @Column(name = "end_date")
        var endDate: Date = Date()

)