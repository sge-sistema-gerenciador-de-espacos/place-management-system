package com.pms.placemanagementsystemserverside.domain.scheduling

import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDateModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

interface SchedulingDomain {
    fun findSpaceToThisScheduling(schedulingModel: SchedulingModel, filteredSpaceModels: List<SpaceModel>): SpaceModel
    fun checkSpaceAvailabilityByDateSchedulingIntention(dateSchedulingModels: List<SchedulingDateModel>, spaceModel: SpaceModel): Boolean
}