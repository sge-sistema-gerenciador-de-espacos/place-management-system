package com.pms.placemanagementsystemserverside.repository.clazz.impl

import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.repository.clazz.ClazzJpaRepository
import com.pms.placemanagementsystemserverside.repository.clazz.ClazzRepository
import org.springframework.beans.BeanUtils
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
        val existingClazz = clazzJpaRepository.findById(clazz.id)
        BeanUtils.copyProperties(clazz, existingClazz)
        return clazzJpaRepository.saveAndFlush(existingClazz.get())
    }

    override fun delete(id: Long) {
        val existingClazz = clazzJpaRepository.findById(id)
        clazzJpaRepository.delete(existingClazz.get())
    }
}