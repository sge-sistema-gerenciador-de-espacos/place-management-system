package com.pms.placemanagementsystemserverside.repository.space

import com.pms.placemanagementsystemserverside.models.space.SpaceModel

interface SpaceRepository {
    fun create(space: SpaceModel): SpaceModel
    fun read(): List<SpaceModel>
    fun update(space: SpaceModel): SpaceModel
    fun delete(id: Long)
}