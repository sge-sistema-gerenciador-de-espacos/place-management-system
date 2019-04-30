package com.pms.placemanagementsystemserverside.service.software

import com.pms.placemanagementsystemserverside.models.software.SoftwareModel

interface SoftwareService {
    fun saveSoftware(softwareModel: SoftwareModel): SoftwareModel
    fun listSoftwares(softwareModel: SoftwareModel?): List<SoftwareModel>
    fun listSoftwaresByComputerLab(id: Long): List<SoftwareModel>
    fun updateSoftware(softwareModel: SoftwareModel)
    fun deleteSoftware(id: Long)
}