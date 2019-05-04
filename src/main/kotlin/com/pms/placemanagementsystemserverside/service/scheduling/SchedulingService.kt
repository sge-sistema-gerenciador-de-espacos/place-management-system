package com.pms.placemanagementsystemserverside.service.scheduling

import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel

interface SchedulingService {
    fun create(schedulingModel: SchedulingModel): SchedulingModel
    fun read(): List<SchedulingModel>
    fun update(schedulingModel: SchedulingModel)
    fun delete(id: Long)
}