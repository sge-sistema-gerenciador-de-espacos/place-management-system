package com.pms.placemanagementsystemserverside.domain.scheduling

import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDateModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SchedulingDomain {

    fun findSpaceToThisScheduling(
            schedulingModel: SchedulingModel, filteredSpaceModels: List<SpaceModel>
    ): SpaceModel {

        filteredSpaceModels.forEach {
            if (checkSpaceAvailabilityBySchedulingDateIntentionList(it, schedulingModel.schedulingDateModels))
                return it
        }

        throw Exception("There is no space available for this scheduling")
    }

    private fun checkSpaceAvailabilityBySchedulingDateIntentionList(
            spaceFoundModel: SpaceModel, intentionSchedulingDateModels: List<SchedulingDateModel>
    ): Boolean {

        val schedulingFoundModels = spaceFoundModel.schedulingModels

        schedulingFoundModels.forEach { schedulingFoundModel ->
            schedulingFoundModel.schedulingDateModels.forEach { schedulingDateFoundModels ->
                intentionSchedulingDateModels.forEach { intentionSchedulingDateModel ->

                    if (schedulingDateFoundModels.date == intentionSchedulingDateModel.date) {
                        if (schedulingDateFoundModels.startTime == intentionSchedulingDateModel.startTime ||
                                schedulingDateFoundModels.startTime == intentionSchedulingDateModel.startTime) {
                            return false
                        }
                    }
                }

            }
        }
        return true
    }

}