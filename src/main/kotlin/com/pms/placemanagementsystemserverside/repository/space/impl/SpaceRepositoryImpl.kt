package com.pms.placemanagementsystemserverside.repository.space.impl

import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.repository.space.SpaceJpaRepository
import com.pms.placemanagementsystemserverside.repository.space.SpaceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository


@Repository
class SpaceRepositoryImpl : SpaceRepository {

    @Autowired
    private lateinit var spaceJpaRepository: SpaceJpaRepository

    override fun create(space: SpaceModel): SpaceModel {
        return spaceJpaRepository.saveAndFlush(space)
    }

    override fun read(): List<SpaceModel> {
        return spaceJpaRepository.findAll()
    }

    override fun update(space: SpaceModel): SpaceModel {
        return if (spaceJpaRepository.findById(space.id).isPresent) spaceJpaRepository.saveAndFlush(space)
        else SpaceModel()
    }

    override fun delete(id: Long) {
        val existingSpace = spaceJpaRepository.findById(id)
        spaceJpaRepository.delete(existingSpace.get())
    }
}