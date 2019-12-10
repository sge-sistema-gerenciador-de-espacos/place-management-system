package com.pms.placemanagementsystemserverside.dto

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel

data class SpaceItemDto(
        var numberOfChairs: Int = 0,
        var hasProjector: Boolean = false,
        var hasBoard: Boolean = false,
        var hasSmartBoard: Boolean = false,
        var type: SpaceTypeEnum = SpaceTypeEnum.UNKNOWN,
        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN,
        val schedulingModels: MutableList<SchedulingModel> = mutableListOf(),
        var numberOfPcs: Int = 0,
        var softwares: List<SoftwareModel> = mutableListOf()
)