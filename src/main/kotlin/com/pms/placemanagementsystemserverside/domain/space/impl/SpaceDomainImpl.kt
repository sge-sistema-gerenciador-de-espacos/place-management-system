package com.pms.placemanagementsystemserverside.domain.space.impl

import com.pms.placemanagementsystemserverside.domain.space.SpaceDomain
import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SpaceDomainImpl : SpaceDomain {

    override fun filterSpaceListBySpaceIntention(
            spaceModels: List<SpaceModel>, spaceIntentionModel: SpaceModel
    ): List<SpaceModel> {

        val filteredSpaceModels = spaceModels.filter {
            it.hasBoard == spaceIntentionModel.hasBoard &&
                    it.hasSmartBoard == spaceIntentionModel.hasSmartBoard &&
                    it.hasProjector == spaceIntentionModel.hasProjector &&
                    it.numberOfChairs == spaceIntentionModel.numberOfChairs
        }

        if (spaceIntentionModel.spaceType == SpaceTypeEnum.COMPUTER_LAB) {
            filterComputerLabByfilteredComputerLabList(
                    (spaceIntentionModel as ComputerLabModel),
                    (filteredSpaceModels as List<ComputerLabModel>))

        } else {
            return filteredSpaceModels
        }

        throw Exception("There is no space available for this intention!")
    }

    //TODO estou ignorando software no filtro
    private fun filterComputerLabByfilteredComputerLabList(
            computerLab: ComputerLabModel, filteredComputerLabList: List<ComputerLabModel>): List<ComputerLabModel> {

        return filteredComputerLabList.filter {
            it.numberOfPcs == computerLab.numberOfPcs
        }
    }

}