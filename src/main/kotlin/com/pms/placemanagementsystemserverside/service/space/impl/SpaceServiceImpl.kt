package com.pms.placemanagementsystemserverside.service.space.impl

import com.pms.placemanagementsystemserverside.domain.space.SpaceDomain
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.repository.space.SpaceRepository
import com.pms.placemanagementsystemserverside.service.space.SpaceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SpaceServiceImpl : SpaceService {

    @Autowired
    private lateinit var spaceRepository: SpaceRepository

    @Autowired
    private lateinit var spaceDomain: SpaceDomain

    override fun create(spaceModel: SpaceModel): SpaceModel {
        return spaceRepository.create(spaceModel)
    }

    override fun read(): List<SpaceModel> {
        return spaceRepository.read()
    }

    override fun update(spaceModel: SpaceModel) {
        spaceRepository.update(spaceModel)
    }

    override fun delete(id: Long) {
        spaceRepository.delete(id)
    }

    override fun filterSpaceBySpaceIntention(spaceModel: SpaceModel): List<SpaceModel> {
        return spaceDomain.filterSpaceListBySpaceIntention(read(), spaceModel)
    }

}