package com.pms.placemanagementsystemserverside.repository.scheduling.impl

import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.repository.scheduling.SchedulingJpaRepository
import com.pms.placemanagementsystemserverside.repository.scheduling.SchedulingRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class SchedulingRepositoryImpl : SchedulingRepository {

    @Autowired
    private lateinit var schedulingJpaRepository: SchedulingJpaRepository

    override fun create(scheduling: SchedulingModel): SchedulingModel {
        return schedulingJpaRepository.saveAndFlush(scheduling)
    }

    override fun read(): List<SchedulingModel> {
        return schedulingJpaRepository.findAll()
    }

    override fun update(scheduling: SchedulingModel): SchedulingModel {
        val existingScheduling = schedulingJpaRepository.findById(scheduling.id)
        BeanUtils.copyProperties(scheduling, existingScheduling)
        return schedulingJpaRepository.saveAndFlush(existingScheduling.get())
    }

    override fun delete(id: Long) {
        val existingScheduling = schedulingJpaRepository.findById(id)
        schedulingJpaRepository.delete(existingScheduling.get())
    }
}