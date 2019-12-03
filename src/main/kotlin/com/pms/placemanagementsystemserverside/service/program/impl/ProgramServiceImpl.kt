package com.pms.placemanagementsystemserverside.service.program.impl

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.program.ProgramModel
import com.pms.placemanagementsystemserverside.repository.program.ProgramRepository
import com.pms.placemanagementsystemserverside.service.program.ProgramService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProgramServiceImpl : ProgramService {

    @Autowired
    private lateinit var programRepository: ProgramRepository

    override fun create(programModel: ProgramModel): ProgramModel {
        return programRepository.create(programModel)
    }

    override fun read(): List<ProgramModel> {
        return programRepository.read()
    }

    override fun readActive(): List<ProgramModel> {
        return read().filter { it.status == ActivationModelStatusEnum.ACTIVE }
    }

    override fun update(programModel: ProgramModel) {
        programRepository.update(programModel)
    }

    override fun delete(id: Long) {
        programRepository.delete(id)
    }
}