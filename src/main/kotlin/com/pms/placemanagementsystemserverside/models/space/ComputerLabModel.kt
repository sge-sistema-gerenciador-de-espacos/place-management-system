package com.pms.placemanagementsystemserverside.models.space

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum
import com.pms.placemanagementsystemserverside.models.software.SoftwareModel
import javax.persistence.Column

//@Entity(name = "ComputerLabModel")
//@DiscriminatorValue(value = "ComputerLabModel")
data class ComputerLabModel(

        override var id: Long,
        override var name: String,
        override var numberOfChairs: Int,
        override var hasProjector: Boolean,
        override var hasBoard: Boolean,
        override var hasSmartBoard: Boolean,

        @Column
        var numberOfPcs: Int = 0,

        @Column
        var softwares: MutableList<SoftwareModel> = mutableListOf()
)

    : SpaceModel(id = id, name = name, numberOfChairs = numberOfChairs, hasProjector = hasProjector,
        hasBoard = hasBoard, hasSmartBoard = hasSmartBoard, typeOfSpace = TypeOfSpaceEnum.COMPUTER_LAB)