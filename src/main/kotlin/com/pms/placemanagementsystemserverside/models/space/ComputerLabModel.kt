package com.pms.placemanagementsystemserverside.models.space

import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
data class ComputerLabModel(

        override var id: Long,
        override var name: String,
        override var numberOfChairs: Int,
        override var hasProjector: Boolean,
        override var hasBoard: Boolean,
        override var hasSmartBoard: Boolean,

        @Column(name = "number_pc")
        var numberOfPcs: Int = 0,

        @ManyToMany
        var softwares: MutableList<SoftwareModel> = mutableListOf()
)

    : SpaceModel(id = id, name = name, numberOfChairs = numberOfChairs, hasProjector = hasProjector,
        hasBoard = hasBoard, hasSmartBoard = hasSmartBoard, spaceType = SpaceTypeEnum.COMPUTER_LAB)