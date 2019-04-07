package com.pms.placemanagementsystemserverside.models

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE)
open class SpaceModel(

//        @Id
//        @Generatedvalue(strategy = GenerationType.AUTO)
//        @Column(name = "id", updatable = false, nullable = false)
        var id: Long,

//        @Column
        var name: String,

//        @Column
        var numberOfChairs: Int,

//        @Column
        var hasProjector: Boolean,

        //        @Column
        var hasBoard: Boolean,

        //        @Column
        var hasSmartBoard: Boolean,

//        @Column
        var typeOfSpace: TypeOfSpaceEnum
)