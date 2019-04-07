package com.pms.placemanagementsystemserverside.models

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum

//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
open class SpaceModel(

//        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
//        @Column(name = "id", updatable = false, nullable = false)
        private val id: Long,

//        @Column
        private val name: String,

//        @Column
        private val numberOfChairs: Int,

//        @Column
        private val hasProjector: Boolean,

//        @Column
        private val typeOfSpace: TypeOfSpaceEnum
)