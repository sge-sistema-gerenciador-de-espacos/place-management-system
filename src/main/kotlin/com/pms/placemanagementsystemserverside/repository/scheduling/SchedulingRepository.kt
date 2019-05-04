package com.pms.placemanagementsystemserverside.repository.scheduling

import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel

interface SchedulingRepository {
    fun create(scheduling: SchedulingModel): SchedulingModel
    fun read(): List<SchedulingModel>
    fun update(scheduling: SchedulingModel): SchedulingModel
    fun delete(id: Long)
}