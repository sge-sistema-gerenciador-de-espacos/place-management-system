package com.pms.placemanagementsystemserverside.service.clazz

import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel

interface ClazzService {
    fun create(clazzModel: ClazzModel): ClazzModel
    fun read(): List<ClazzModel>
    fun update(clazzModel: ClazzModel)
    fun delete(id: Long)
}
