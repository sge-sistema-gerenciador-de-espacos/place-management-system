package com.pms.placemanagementsystemserverside.service.space

import com.pms.placemanagementsystemserverside.dto.SpaceSoftwareDto
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel

interface SpaceService {
    fun create(spaceModel: SpaceModel): SpaceModel
    fun read(): List<SpaceModel>
    fun readSoftwareBySpaceId(spaceId: Long): List<SoftwareModel>
    fun update(spaceModel: SpaceModel)
    fun delete(id: Long)
    fun filterSpaceBySpaceIntention(spaceModel: SpaceModel): List<SpaceModel>
    fun deleteSoftwareOfSpace(spaceSoftwareDto: SpaceSoftwareDto)
    fun addSoftwareOfSpace(spaceSoftwareDto: SpaceSoftwareDto)
}