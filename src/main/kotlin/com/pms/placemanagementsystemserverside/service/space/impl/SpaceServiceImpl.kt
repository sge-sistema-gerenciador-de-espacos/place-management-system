package com.pms.placemanagementsystemserverside.service.space.impl

import com.pms.placemanagementsystemserverside.domain.space.SpaceDomain
import com.pms.placemanagementsystemserverside.dto.SpaceSoftwareDto
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
import com.pms.placemanagementsystemserverside.repository.space.SpaceRepository
import com.pms.placemanagementsystemserverside.service.software.SoftwareService
import com.pms.placemanagementsystemserverside.service.space.SpaceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SpaceServiceImpl : SpaceService {

    @Autowired
    private lateinit var spaceRepository: SpaceRepository

    @Autowired
    private lateinit var softwareService: SoftwareService

    private val spaceDomain: SpaceDomain by lazy { SpaceDomain() }

    override fun create(spaceModel: SpaceModel): SpaceModel {
        return spaceRepository.create(spaceModel)
    }

    override fun read(): List<SpaceModel> {
        return spaceRepository.read()
    }

    override fun readSoftwareBySpaceId(spaceId: Long): List<SoftwareModel> {
        return softwareService.readBySpace(spaceId)
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

    override fun deleteSoftwareOfSpace(spaceSoftwareDto: SpaceSoftwareDto) {
        addOrRemoveSoftwareOfSpace(ManipulationSoftwareOfSpaceType.DELETE, spaceSoftwareDto)
    }

    override fun addSoftwareOfSpace(spaceSoftwareDto: SpaceSoftwareDto) {
        addOrRemoveSoftwareOfSpace(ManipulationSoftwareOfSpaceType.ADD, spaceSoftwareDto)
    }

    private fun addOrRemoveSoftwareOfSpace(
            manipulationSoftwareOfSpaceType: ManipulationSoftwareOfSpaceType, spaceSoftwareDto: SpaceSoftwareDto
    ) {

        val spaceList = spaceRepository.read()
        val spaceModel = spaceList.find { it.id == spaceSoftwareDto.spaceId }!!
        val softwareList = spaceModel.softwares.toMutableList()

        if (manipulationSoftwareOfSpaceType == ManipulationSoftwareOfSpaceType.ADD) {
            val softwareModel = softwareService.read().find { it.id == spaceSoftwareDto.softwareId }!!
            softwareList.add(softwareModel)

        } else {
            val softwareModel = softwareList.find { it.id == spaceSoftwareDto.softwareId }
            softwareList.remove(softwareModel)
        }

        spaceModel.softwares = softwareList.toList()
        //TODO acertar isso, tema algum erro  nesse uptade, pode ser a anotacao do relacionamento
        spaceRepository.update(spaceModel)
    }

    private enum class ManipulationSoftwareOfSpaceType { ADD, DELETE }

}