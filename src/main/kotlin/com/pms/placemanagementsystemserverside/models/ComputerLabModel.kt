package com.pms.placemanagementsystemserverside.models

import com.pms.placemanagementsystemserverside.models.enums.Software
import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum

data class ComputerLabModel(private val id: Long, private val name: String, private val numberOfChairs: Int,
                            private val hasProjector: Boolean, private val numberOfPcs: Int,
                            private val softwares: MutableList<Software>)
    : SpaceModel(id, name, numberOfChairs, hasProjector, TypeOfSpaceEnum.COMPUTER_LAB)