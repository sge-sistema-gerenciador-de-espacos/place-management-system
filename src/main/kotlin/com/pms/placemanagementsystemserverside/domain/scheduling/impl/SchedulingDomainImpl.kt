package com.pms.placemanagementsystemserverside.domain.scheduling.impl

import com.pms.placemanagementsystemserverside.domain.scheduling.SchedulingDomain
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDateModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import org.springframework.stereotype.Component

class SchedulingDomainImpl : SchedulingDomain {

    override fun findSpaceToThisScheduling(
            schedulingModel: SchedulingModel, filteredSpaceModels: List<SpaceModel>
    ): SpaceModel {

        var spaceModel: SpaceModel? = null

        filteredSpaceModels.forEach {
            if (checkSpaceAvailabilityByDateSchedulingIntention(schedulingModel.schedulingDateModels, it))
                spaceModel = it
        }

        return spaceModel ?: throw Exception("There is no space available for this scheduling")
    }

    override fun checkSpaceAvailabilityByDateSchedulingIntention(
            dateSchedulingModelModels: List<SchedulingDateModel>, spaceModel: SpaceModel
    ): Boolean {

        //TODO fazer a logica de verificacao de espaco disponivel

        return true
    }

}