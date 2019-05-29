package com.pms.placemanagementsystemserverside.domain.space.impl

import com.pms.placemanagementsystemserverside.domain.space.SpaceDomain
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SpaceDomainImpl : SpaceDomain {
    override fun filterSpaceBySpaceIntention(
            spaceModel: SpaceModel, spaceModels: List<SpaceModel>
    ): List<SpaceModel> {
//TODO falta verificar caso for um lab
        return spaceModels.filter {
            it.hasBoard == spaceModel.hasBoard
            it.hasSmartBoard == spaceModel.hasSmartBoard
            it.hasProjector == spaceModel.hasProjector
            it.numberOfChairs == spaceModel.numberOfChairs
//            if (spaceModel is ComputerLabModel) {
//                (it as ComputerLabModel).numberOfPcs == (spaceModel as ComputerLabModel).numberOfPcs
//            }
        }
    }

}