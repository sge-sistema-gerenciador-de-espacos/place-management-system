package com.pms.placemanagementsystemserverside.domain.space

import com.pms.placemanagementsystemserverside.models.space.SpaceModel

interface SpaceDomain {
    fun filterSpaceBySpaceIntention(spaceModel: SpaceModel, spaceModels: List<SpaceModel>): List<SpaceModel>
}