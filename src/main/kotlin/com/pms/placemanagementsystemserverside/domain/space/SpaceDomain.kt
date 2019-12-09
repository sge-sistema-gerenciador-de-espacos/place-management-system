package com.pms.placemanagementsystemserverside.domain.space

import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SpaceDomain {

    fun filterSpaceListBySpaceIntention(
            spaceModels: List<SpaceModel>, spaceIntentionModel: SpaceModel
    ): List<SpaceModel> {

        val filteredSpaceModels = spaceModels.filter {
            it.hasBoard == spaceIntentionModel.hasBoard &&
                    it.hasSmartBoard == spaceIntentionModel.hasSmartBoard &&
                    it.hasProjector == spaceIntentionModel.hasProjector &&
                    it.extraConditionToFilterSpaceIntention(spaceIntentionModel)
        }

        if (filteredSpaceModels.isEmpty()) {
            throw Exception("There is no space available for this intention!")
        }

        filteredSpaceModels.sortedBy {
            if (it.type == SpaceTypeEnum.CLASSROOM)
                it.numberOfChairs
            else it.numberOfPcs
        }

        return filteredSpaceModels
    }

}