package com.pms.placemanagementsystemserverside.service.space

import com.pms.placemanagementsystemserverside.models.space.SpaceModel

interface SpaceService {
    fun saveSpace(spaceModel: SpaceModel): SpaceModel
    fun listSpaces(spaceModel: SpaceModel?): List<SpaceModel>
    fun updateSpace(spaceModel: SpaceModel)
    fun deleteSpace(id: Long)
}