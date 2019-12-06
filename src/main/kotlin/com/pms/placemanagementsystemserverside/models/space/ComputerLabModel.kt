package com.pms.placemanagementsystemserverside.models.space

import com.fasterxml.jackson.annotation.JsonProperty
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany

//TODO aplicar a anotacao correta do mapeamento de JPA, esse cara precisa ser relacionado com space no banco
@Entity
data class ComputerLabModel(

        override var id: Long = 0,
        override var name: String = "",
        override var numberOfChairs: Int = 0,
        override var hasProjector: Boolean = false,
        override var hasBoard: Boolean = false,
        override var hasSmartBoard: Boolean = false,
        override var type: SpaceTypeEnum = SpaceTypeEnum.UNKNOWN,
        override var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN,

        @Column(name = "number_pc")
        @JsonProperty(value = "numberPc")
        var numberOfPcs: Int = 0,

        @ManyToMany
        var softwares: MutableList<SoftwareModel> = mutableListOf()

) : SpaceModel(id = id, name = name, numberOfChairs = numberOfChairs, hasProjector = hasProjector,
        hasBoard = hasBoard, hasSmartBoard = hasSmartBoard, type = SpaceTypeEnum.COMPUTER_LAB)