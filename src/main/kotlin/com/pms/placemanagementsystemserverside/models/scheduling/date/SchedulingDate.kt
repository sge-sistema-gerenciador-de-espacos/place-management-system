package com.pms.placemanagementsystemserverside.models.scheduling.date

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "scheduling_date")
data class SchedulingDate(

        @Column(name = "start_date")
        var startDate: Date = Date(),

        @Column(name = "end_date")
        var endDate: Date = Date()

)