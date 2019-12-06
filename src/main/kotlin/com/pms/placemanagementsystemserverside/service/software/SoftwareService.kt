package com.pms.placemanagementsystemserverside.service.software

import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel

interface SoftwareService {
    fun create(softwareModel: SoftwareModel): SoftwareModel
    fun read(): List<SoftwareModel>
    fun readActive(): List<SoftwareModel>
    fun readBySpace(labId: Long): List<SoftwareModel>
    fun update(softwareModel: SoftwareModel)
    fun delete(id: Long)
}