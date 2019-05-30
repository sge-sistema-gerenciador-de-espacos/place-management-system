package com.pms.placemanagementsystemserverside.domain.space

import com.pms.placemanagementsystemserverside.models.space.SpaceModel

interface SpaceDomain {
    fun filterSpaceListBySpaceIntention(
            spaceModels: List<SpaceModel>, spaceIntentionModel: SpaceModel
    ): List<SpaceModel>
}