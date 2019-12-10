package com.pms.placemanagementsystemserverside.domain.scheduling

import com.pms.placemanagementsystemserverside.models.enums.SchedulingStatusEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDateModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SchedulingDomain {

    fun findSpaceToThisScheduling(
            schedulingModel: SchedulingModel, filteredSpaceModels: List<SpaceModel>
    ): SpaceModel {

        filteredSpaceModels.forEach {
            if (checkSpaceAvailabilityBySchedulingDateIntentionList(it, schedulingModel.schedulingDateModels)) {
                schedulingModel.status = SchedulingStatusEnum.ACCEPTED
                return it
            }
        }

        schedulingModel.status = SchedulingStatusEnum.WAITING
        return filteredSpaceModels.let {
            if (it.isEmpty()) {
                SpaceModel()
            } else {
                it[0]
            }
        }
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
                                schedulingDateFoundModels.endTime == intentionSchedulingDateModel.endTime) {
                            return false
                        }
                    }
                }

            }
        }
        return true
    }

}