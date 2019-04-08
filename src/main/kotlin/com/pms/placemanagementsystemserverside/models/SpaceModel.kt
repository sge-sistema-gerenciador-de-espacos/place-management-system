package com.pms.placemanagementsystemserverside.models

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE)
open class SpaceModel(

//        @Id
//        @Generatedvalue(strategy = GenerationType.AUTO)
//        @Column(name = "id", updatable = false, nullable = false)
        var id: Long = 0,

//        @Column
        var name: String = "",

//        @Column
        var numberOfChairs: Int = 0,

//        @Column
        var hasProjector: Boolean = false,

        //        @Column
        var hasBoard: Boolean = false,

        //        @Column
        var hasSmartBoard: Boolean = false,

//        @Column
        var typeOfSpace: TypeOfSpaceEnum = TypeOfSpaceEnum.CLASSROOM
)