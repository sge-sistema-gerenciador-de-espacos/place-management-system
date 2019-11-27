package com.pms.placemanagementsystemserverside.service.program

import com.pms.placemanagementsystemserverside.models.program.ProgramModel

interface ProgramService {
    fun create(programModel: ProgramModel): ProgramModel
    fun read(): List<ProgramModel>
    fun readActive(): List<ProgramModel>
    fun update(programModel: ProgramModel)
    fun delete(id: Long)
}
