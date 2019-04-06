package models

import models.enums.TypeOfSpaceEnum

data class ClassRoomModel(private val name: String, private val numberOfChairs: Int,
                          private val hasProjector: Boolean, private val hasBoard: Boolean,
                          private val hasSmartBoard: Boolean)
    : SpaceModel(name, numberOfChairs, hasProjector, TypeOfSpaceEnum.CLASSROOM)
