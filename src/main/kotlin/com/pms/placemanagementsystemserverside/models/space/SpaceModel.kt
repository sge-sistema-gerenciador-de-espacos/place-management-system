package com.pms.placemanagementsystemserverside.models.space

import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum
import org.springframework.data.annotation.Id
import javax.persistence.*

@Entity(name = "space")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
open class SpaceModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "space_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
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