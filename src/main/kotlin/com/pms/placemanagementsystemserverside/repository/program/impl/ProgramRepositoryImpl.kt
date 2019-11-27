package com.pms.placemanagementsystemserverside.repository.program.impl

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.program.ProgramModel
import com.pms.placemanagementsystemserverside.repository.program.ProgramJpaRepository
import com.pms.placemanagementsystemserverside.repository.program.ProgramRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Repository


@Repository
class ProgramRepositoryImpl : ProgramRepository {

    @Autowired
    private lateinit var programJpaRepository: ProgramJpaRepository

    override fun create(program: ProgramModel): ProgramModel {
        return programJpaRepository.saveAndFlush(program)
    }

    override fun read(): List<ProgramModel> {
        return programJpaRepository.findAll()
    }

    override fun readActive(): List<ProgramModel> {
        return programJpaRepository.findAll(Example.of(ProgramModel(status = ActivationModelStatusEnum.ACTIVE)))
    }

    override fun update(program: ProgramModel): ProgramModel {
        return if (programJpaRepository.findById(program.id ?: 0).isPresent) {
            programJpaRepository.saveAndFlush(program)
        } else {
            ProgramModel()
        }
    }

    override fun delete(id: Long) {
        val existingProgram = programJpaRepository.findById(id)
        programJpaRepository.delete(existingProgram.get())
    }
}