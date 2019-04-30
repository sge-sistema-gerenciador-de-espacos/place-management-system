package com.pms.placemanagementsystemserverside.service.software.impl

import com.pms.placemanagementsystemserverside.models.software.SoftwareModel
import com.pms.placemanagementsystemserverside.service.software.SoftwareService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SoftwareServiceImpl : SoftwareService {

    @Autowired
    private lateinit var softwareDao: SoftwareDao

    override fun saveSoftware(softwareModel: SoftwareModel): SoftwareModel {
        return softwareDao.saveSoftware(softwareModel)
    }

    override fun listSoftwares(softwareModel: SoftwareModel?): List<SoftwareModel> {
        return softwareDao.listSoftwares(softwareModel)
    }

    override fun listSoftwaresByComputerLab(id: Long): List<SoftwareModel> {
        return softwareDao.listSoftwaresByComputerLab(id)
    }

    override fun updateSoftware(softwareModel: SoftwareModel) {
        softwareDao.updateSoftware(softwareModel)
    }

    override fun deleteSoftware(id: Long) {
        softwareDao.deleteSoftware(id)
    }

}