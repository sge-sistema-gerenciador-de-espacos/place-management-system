package com.pms.placemanagementsystemserverside.service.scheduling.impl

import com.pms.placemanagementsystemserverside.domain.scheduling.SchedulingDomain
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.repository.scheduling.SchedulingRepository
import com.pms.placemanagementsystemserverside.service.scheduling.SchedulingService
import com.pms.placemanagementsystemserverside.service.space.SpaceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SchedulingServiceImpl : SchedulingService {

    @Autowired
    private lateinit var schedulingRepository: SchedulingRepository

    private val schedulingDomain: SchedulingDomain by lazy { SchedulingDomain() }

    @Autowired
    private lateinit var spaceService: SpaceService


    override fun create(schedulingModel: SchedulingModel): SchedulingModel {
        //TODO fazer a parte de se enviar espaco
        // TODO verificar se spaceFound id é diferente de 0 antes de fazer a logica
        val filteredSpaces = spaceService.filterSpaceBySpaceIntention(schedulingModel.getSpaceIntention())
        val spaceModelFound = schedulingDomain.findSpaceToThisScheduling(schedulingModel, filteredSpaces)
//        schedulingModel.schedulingDateModels.forEach { it.space = spaceModelFound }
        schedulingModel.spaceFound = spaceModelFound
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