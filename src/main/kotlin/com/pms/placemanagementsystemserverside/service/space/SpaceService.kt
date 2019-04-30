package com.pms.placemanagementsystemserverside.service.space

import com.pms.placemanagementsystemserverside.models.space.SpaceModel

interface SpaceService {
    fun create(spaceModel: SpaceModel): SpaceModel
    fun read(): List<SpaceModel>
    fun update(spaceModel: SpaceModel)
    fun delete(id: Long)
}