package com.pms.placemanagementsystemserverside.domain.impl

import com.pms.placemanagementsystemserverside.domain.SchedulingDomain
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SchedulingDomainImpl : SchedulingDomain {

    override fun schedule(schedulingModel: SchedulingModel, spaceModel: List<SpaceModel>): SchedulingModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun filterBySpace(schedulingModel: SchedulingModel, spaceModel: List<SpaceModel>): SpaceModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checkAvailability(spaceModel: SpaceModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}