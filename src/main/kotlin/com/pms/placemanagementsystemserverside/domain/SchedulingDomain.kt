package com.pms.placemanagementsystemserverside.domain

import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

interface SchedulingDomain {
    fun schedule(schedulingModel: SchedulingModel, spaceModel: List<SpaceModel>): SchedulingModel
    fun filterBySpace(schedulingModel: SchedulingModel, spaceModel: List<SpaceModel>): SpaceModel
    fun checkAvailability(spaceModel: SpaceModel)
}