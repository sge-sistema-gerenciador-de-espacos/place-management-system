package com.pms.placemanagementsystemserverside.models.space

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum
import org.springframework.data.annotation.Id
import javax.persistence.*

@Entity
//@Entity(name = "space")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
open class SpaceModel {

    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    //        @Column(name = "name")
    var name: String = ""

    //        @Column(name = "number_chair")
    var numberOfChairs: Int = 0

    //        @Column(name = "projector")
    var hasProjector: Boolean = false

    //        @Column(name = "board")
    var hasBoard: Boolean = false

    //        @Column(name = "smart_board")
    var hasSmartBoard: Boolean = false

    //        @Column(name = "type")
    var typeOfSpace: TypeOfSpaceEnum = TypeOfSpaceEnum.CLASSROOM

    constructor()

    constructor(id: Long, name: String, numberOfChairs: Int, hasProjector: Boolean, hasBoard: Boolean,
                hasSmartBoard: Boolean, typeOfSpace: TypeOfSpaceEnum) {
        this.id = id
        this.name = name
        this.numberOfChairs = numberOfChairs
        this.hasProjector = hasProjector
        this.hasBoard = hasBoard
        this.hasSmartBoard = hasSmartBoard
        this.typeOfSpace = typeOfSpace
    }


    override fun toString(): String {
        return "SpaceModel(id=$id, name='$name', numberOfChairs=$numberOfChairs, hasProjector=$hasProjector, " +
                "hasBoard=$hasBoard, hasSmartBoard=$hasSmartBoard, typeOfSpace=$typeOfSpace)"
    }


}