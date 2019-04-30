package com.pms.placemanagementsystemserverside.repository.space

import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import org.springframework.data.jpa.repository.JpaRepository

interface SpaceJpaRepository : JpaRepository<SpaceModel, Long>
//interface SpaceJpaRepository {
//    fun saveAndFlush(space: SpaceModel): SpaceModel
//    fun findAll(): List<SpaceModel>
//    fun delete(space: SpaceModel): SpaceModel
//    fun findById(id: Long): Optional<SpaceModel>
//}