package com.pms.placemanagementsystemserverside.repository.space.impl

import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.repository.space.SpaceJpaRepository
import com.pms.placemanagementsystemserverside.repository.space.SpaceRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository


@Repository
class SpaceRepositoryImpl : SpaceRepository {

    val logger = LoggerFactory.getLogger(SpaceRepositoryImpl::class.java)

    @Autowired
    private lateinit var spaceJpaRepository: SpaceJpaRepository

    override fun create(space: SpaceModel): SpaceModel {
        return spaceJpaRepository.saveAndFlush(space)
    }

    override fun read(): List<SpaceModel> {
        return spaceJpaRepository.findAll()
    }

    override fun update(space: SpaceModel): SpaceModel {
        var spaceModel = SpaceModel()

        try {
            if (spaceJpaRepository.findById(space.id).isPresent) {
                spaceModel = spaceJpaRepository.saveAndFlush(space)
            }

        } catch (e: Exception) {
            logger.error("update", e)
        }

        return spaceModel
    }

    override fun delete(id: Long) {
        val existingSpace = spaceJpaRepository.findById(id)
        spaceJpaRepository.delete(existingSpace.get())
    }
}