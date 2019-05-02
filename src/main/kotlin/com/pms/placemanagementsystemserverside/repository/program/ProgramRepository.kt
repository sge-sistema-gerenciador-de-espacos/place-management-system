package com.pms.placemanagementsystemserverside.repository.program

import com.pms.placemanagementsystemserverside.models.program.ProgramModel

interface ProgramRepository {
    fun create(program: ProgramModel): ProgramModel
    fun read(): List<ProgramModel>
    fun update(program: ProgramModel): ProgramModel
    fun delete(id: Long)
}