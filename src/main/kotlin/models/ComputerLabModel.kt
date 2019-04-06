package models

import models.enums.TypeOfSpaceEnum

data class ComputerLabModel(private val name: String, private val numberOfChairs: Int,
                            private val hasProjector: Boolean, private val numeberOfPcs: Int)
    : SpaceModel(name, numberOfChairs, hasProjector, TypeOfSpaceEnum.COMPUTER_LAB)