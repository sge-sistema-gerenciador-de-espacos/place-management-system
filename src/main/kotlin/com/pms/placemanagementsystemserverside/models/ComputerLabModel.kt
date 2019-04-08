package com.pms.placemanagementsystemserverside.models

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum

class ComputerLabModel(id: Long, name: String, numberOfChairs: Int,
                       hasProjector: Boolean, hasBoard: Boolean,
                       hasSmartBoard: Boolean, var numberOfPcs: Int,
                       var softwares: MutableList<SoftwareModel>)
    : SpaceModel(id = id, name = name, numberOfChairs = numberOfChairs, hasProjector = hasProjector,
        hasBoard = hasBoard, hasSmartBoard = hasSmartBoard, typeOfSpace = TypeOfSpaceEnum.COMPUTER_LAB)