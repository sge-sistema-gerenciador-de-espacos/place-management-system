package com.pms.placemanagementsystemserverside.service.space.impl

import com.pms.placemanagementsystemserverside.dao.space.SpaceDao
import com.pms.placemanagementsystemserverside.dao.spacesoftware.SpaceSoftwareDao
import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum
import com.pms.placemanagementsystemserverside.models.software.SoftwareModel
import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.service.software.SoftwareService
import com.pms.placemanagementsystemserverside.service.space.SpaceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SpaceServiceImpl : SpaceService {

    @Autowired
    private lateinit var spaceDao: SpaceDao

    @Autowired
    private lateinit var softwareService: SoftwareService

    @Autowired
    private lateinit var spaceSoftwareDao: SpaceSoftwareDao

    override fun saveSpace(spaceModel: SpaceModel): SpaceModel {
        val saveSpace = spaceDao.saveSpace(spaceModel)

        if (saveSpace.typeOfSpace == TypeOfSpaceEnum.COMPUTER_LAB) {
            (saveSpace as ComputerLabModel).softwares?.forEach {
                spaceSoftwareDao.saveSpaceSoftware(spaceId = saveSpace.id!!, softwareId = it.id!!)
            }
        }

        return saveSpace
    }

    override fun listSpaces(spaceModel: SpaceModel?): List<SpaceModel> {
        val listSpaces = spaceDao.listSpaces(spaceModel)
        var listSoftwaresByComputerLab: List<SoftwareModel>

        listSpaces.forEach {

            if (it.typeOfSpace == TypeOfSpaceEnum.COMPUTER_LAB) {
                listSoftwaresByComputerLab = softwareService.listSoftwaresByComputerLab(it.id!!)
                (it as ComputerLabModel).softwares = listSoftwaresByComputerLab
            }

        }

        return listSpaces
    }

    override fun updateSpace(spaceModel: SpaceModel) {
        spaceSoftwareDao.deleteSpaceSoftware(spaceId = spaceModel.id!!)
        saveSpace(spaceModel)
        spaceDao.updateSpace(spaceModel)
    }

    override fun deleteSpace(id: Long) {
        spaceSoftwareDao.deleteSpaceSoftware(spaceId = id)
        spaceDao.deleteSpace(id)
    }
}