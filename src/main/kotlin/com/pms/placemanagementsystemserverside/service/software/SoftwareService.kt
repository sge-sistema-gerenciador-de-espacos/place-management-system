package com.pms.placemanagementsystemserverside.service.software

import com.pms.placemanagementsystemserverside.models.software.SoftwareModel

interface SoftwareService {
    fun create(softwareModel: SoftwareModel): SoftwareModel
    fun read(): List<SoftwareModel>
    fun update(softwareModel: SoftwareModel)
    fun delete(id: Long)
}