package com.pms.placemanagementsystemserverside.repository.clazz

import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel

interface ClazzRepository {
    fun create(clazz: ClazzModel): ClazzModel
    fun read(): List<ClazzModel>
    fun update(clazz: ClazzModel): ClazzModel
    fun delete(id: Long)
}