package com.pms.placemanagementsystemserverside.models.space

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE)
open class SpaceModel(

//        @Id
//        @Generatedvalue(strategy = GenerationType.AUTO)
//        @Column(name = "id", updatable = false, nullable = false)
        open var id: Long = 0,

//        @Column
        open var name: String = "",

//        @Column
        open var numberOfChairs: Int = 0,

//        @Column
        open var hasProjector: Boolean = false,

        //        @Column
        open var hasBoard: Boolean = false,

        //        @Column
        open var hasSmartBoard: Boolean = false,

//        @Column
        val typeOfSpace: TypeOfSpaceEnum = TypeOfSpaceEnum.CLASSROOM
) {

    override fun toString(): String {
        return "SpaceModel(id=$id, name='$name', numberOfChairs=$numberOfChairs, hasProjector=$hasProjector, " +
                "hasBoard=$hasBoard, hasSmartBoard=$hasSmartBoard, typeOfSpace=$typeOfSpace)"
    }

}