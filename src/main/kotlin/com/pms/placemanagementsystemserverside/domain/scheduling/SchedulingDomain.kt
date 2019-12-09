package com.pms.placemanagementsystemserverside.domain.scheduling

import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDateModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SchedulingDomain {

    fun findSpaceToThisScheduling(
            schedulingModel: SchedulingModel, filteredSpaceModels: List<SpaceModel>
    ): SpaceModel {

        var spaceModel: SpaceModel? = null

        filteredSpaceModels.forEach {
            if (checkSpaceAvailabilityBySchedulingDateIntentionList(it, schedulingModel.schedulingDateModels))
                spaceModel = it
        }

        return spaceModel ?: throw Exception("There is no space available for this scheduling")
    }

    private fun checkSpaceAvailabilityBySchedulingDateIntentionList(
            spaceFindedModel: SpaceModel, intentionSchedulingDateModels: List<SchedulingDateModel>
    ): Boolean {

        val schedulingFoundModels = spaceFindedModel.schedulingModels

        schedulingFoundModels.forEach { schedulingFoundModel ->
            schedulingFoundModel.schedulingDateModels.forEach { schedulingDateFoundModels ->
                intentionSchedulingDateModels.forEach { intentionSchedulingDateModel ->

                    if (schedulingDateFoundModels.startDate == intentionSchedulingDateModel.startDate ||
                            schedulingDateFoundModels.startDate == intentionSchedulingDateModel.startDate) {
                        return false
                    }

                }

            }
        }
        return true
    }

}