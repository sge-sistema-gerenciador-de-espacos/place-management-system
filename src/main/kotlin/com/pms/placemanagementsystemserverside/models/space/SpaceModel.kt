package com.pms.placemanagementsystemserverside.models.space

import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import javax.persistence.*

@Entity(name = "space")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
open class SpaceModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "space_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        open var id: Long = 0,

        open var name: String = "",

        @Column(name = "number_chair")
        open var numberOfChairs: Int = 0,

        @Column(name = "projector")
        open var hasProjector: Boolean = false,

        @Column(name = "board")
        open var hasBoard: Boolean = false,

        @Column(name = "smart_board")
        open var hasSmartBoard: Boolean = false,

        @Column(name = "type")
        val spaceType: SpaceTypeEnum = SpaceTypeEnum.CLASSROOM,

        @OneToMany(targetEntity = SchedulingModel::class)
        val schedulingModels: MutableList<SchedulingModel> = mutableListOf()

) {

    override fun toString(): String {
        return "SpaceModel(id=$id, name='$name', numberOfChairs=$numberOfChairs, hasProjector=$hasProjector, " +
                "hasBoard=$hasBoard, hasSmartBoard=$hasSmartBoard, spaceType=$spaceType, " +
                "schedulingModels=$schedulingModels)"
    }

}