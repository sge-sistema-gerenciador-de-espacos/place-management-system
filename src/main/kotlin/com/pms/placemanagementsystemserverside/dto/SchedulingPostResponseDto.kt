package com.pms.placemanagementsystemserverside.dto

import com.pms.placemanagementsystemserverside.models.space.SpaceModel

data class SchedulingPostResponseDto(val id: Long, val status: String, val spaceModel: SpaceModel)