package com.pms.placemanagementsystemserverside.service.scheduling.impl

import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.repository.scheduling.SchedulingRepository
import com.pms.placemanagementsystemserverside.service.scheduling.SchedulingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SchedulingServiceImpl : SchedulingService {

    @Autowired
    private lateinit var schedulingRepository: SchedulingRepository

    override fun create(schedulingModel: SchedulingModel): SchedulingModel {
        return schedulingRepository.create(schedulingModel)
    }

    override fun read(): List<SchedulingModel> {
        return schedulingRepository.read()
    }

    override fun update(schedulingModel: SchedulingModel) {
        schedulingRepository.update(schedulingModel)
    }

    override fun delete(id: Long) {
        schedulingRepository.delete(id)
    }

}