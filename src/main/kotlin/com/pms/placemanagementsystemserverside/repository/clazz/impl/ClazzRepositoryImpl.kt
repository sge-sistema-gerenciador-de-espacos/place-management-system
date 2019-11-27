package com.pms.placemanagementsystemserverside.repository.clazz.impl

import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.repository.clazz.ClazzJpaRepository
import com.pms.placemanagementsystemserverside.repository.clazz.ClazzRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository


@Repository
class ClazzRepositoryImpl : ClazzRepository {

    @Autowired
    private lateinit var clazzJpaRepository: ClazzJpaRepository

    override fun create(clazz: ClazzModel): ClazzModel {
        return clazzJpaRepository.saveAndFlush(clazz)
    }

    override fun read(): List<ClazzModel> {
        return clazzJpaRepository.findAll()
    }

    override fun update(clazz: ClazzModel): ClazzModel {
        if (clazzJpaRepository.findById(clazz.id).isPresent) {
            return clazzJpaRepository.saveAndFlush(clazz)
        }
        return ClazzModel()
    }

    override fun delete(id: Long) {
        val existingClazz = clazzJpaRepository.findById(id)
        clazzJpaRepository.delete(existingClazz.get())
    }
}