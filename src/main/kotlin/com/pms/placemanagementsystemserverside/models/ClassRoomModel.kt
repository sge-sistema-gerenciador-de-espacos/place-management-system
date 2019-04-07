package com.pms.placemanagementsystemserverside.models

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum

data class ClassRoomModel(private val id: Long, private val name: String, private val numberOfChairs: Int,
                          private val hasProjector: Boolean, private val hasBoard: Boolean,
                          private val hasSmartBoard: Boolean)
    : SpaceModel(id, name, numberOfChairs, hasProjector, TypeOfSpaceEnum.CLASSROOM)
