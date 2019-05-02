package com.pms.placemanagementsystemserverside.repository.software

import com.pms.placemanagementsystemserverside.models.software.SoftwareModel

interface SoftwareRepository {
    fun create(software: SoftwareModel): SoftwareModel
    fun read(): List<SoftwareModel>
    fun update(software: SoftwareModel): SoftwareModel
    fun delete(id: Long)
}