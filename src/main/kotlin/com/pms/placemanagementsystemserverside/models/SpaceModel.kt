package com.pms.placemanagementsystemserverside.models

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum

open class SpaceModel(private val name: String, private val numberOfChairs: Int,
                 private val hasProjector: Boolean, private val typeOfSpace: TypeOfSpaceEnum)