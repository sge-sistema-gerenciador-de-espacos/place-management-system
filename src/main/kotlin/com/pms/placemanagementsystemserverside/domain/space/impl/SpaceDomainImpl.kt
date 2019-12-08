package com.pms.placemanagementsystemserverside.domain.space.impl

import com.pms.placemanagementsystemserverside.domain.space.SpaceDomain
import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
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

//        if (spaceIntentionModel.type == SpaceTypeEnum.COMPUTER_LAB) {
//
//            val filterComputerLabModels = mutableListOf<ComputerLabModel>()
//
//            filteredSpaceModels.forEach {
//                if (it.type == SpaceTypeEnum.COMPUTER_LAB) {
//                    filterComputerLabModels.add(it as ComputerLabModel)
//                }
//            }
//
//            filterComputerLabByFilteredSpaceModelList(
//                    (spaceIntentionModel as ComputerLabModel),
//                    filterComputerLabModels
//            )
//
//        } else {
//            return filteredSpaceModels
//        }

        throw Exception("There is no space available for this intention!")
    }

    //TODO estou ignorando software no filtro
//    private fun filterComputerLabByFilteredSpaceModelList(
//            computerLab: ComputerLabModel, filteredComputerLabList: List<ComputerLabModel>): List<ComputerLabModel> {



//        return filteredComputerLabList.filter {
//            it.numberOfPcs == computerLab.numberOfPcs
//        }
//    }

}