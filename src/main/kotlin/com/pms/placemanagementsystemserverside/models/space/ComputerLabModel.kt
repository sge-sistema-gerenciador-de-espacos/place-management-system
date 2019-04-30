package com.pms.placemanagementsystemserverside.models.space

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum
import com.pms.placemanagementsystemserverside.models.software.SoftwareModel
import javax.persistence.Entity

@Entity
class ComputerLabModel : SpaceModel {

    //        @Column(name = "number_pc")
    var numberOfPcs: Int = 0

    //        @ManyToMany
    var softwares: MutableList<SoftwareModel> = mutableListOf()

    constructor() : super()

    constructor(id: Long, name: String, numberOfChairs: Int, hasProjector: Boolean, hasBoard: Boolean,
                hasSmartBoard: Boolean, typeOfSpace: TypeOfSpaceEnum) :
            super(id, name, numberOfChairs, hasProjector, hasBoard, hasSmartBoard, typeOfSpace)

    override fun toString(): String {
        return "${super.toString()} ComputerLabModel(numberOfPcs=$numberOfPcs, softwares=$softwares)"
    }

}