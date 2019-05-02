package com.pms.placemanagementsystemserverside.service.clazz.impl

import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.repository.clazz.ClazzRepository
import com.pms.placemanagementsystemserverside.service.clazz.ClazzService
import org.springframework.beans.factory.annotation.Autowired

class ClazzServiceImpl : ClazzService {

    @Autowired
    private lateinit var clazzRepository: ClazzRepository

    override fun create(clazzModel: ClazzModel): ClazzModel {
        return clazzRepository.create(clazzModel)
    }

    override fun read(): List<ClazzModel> {
        return clazzRepository.read()
    }

    override fun update(clazzModel: ClazzModel) {
        clazzRepository.update(clazzModel)
    }

    override fun delete(id: Long) {
        clazzRepository.delete(id)
    }
}