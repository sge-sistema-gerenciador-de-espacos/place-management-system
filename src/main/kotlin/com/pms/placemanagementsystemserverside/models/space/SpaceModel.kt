package com.pms.placemanagementsystemserverside.models.space

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
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
        @JsonIgnoreProperties(allowGetters = true)
        open var id: Long = 0,

        open var name: String = "",

        @Column(name = "number_chair")
        @JsonProperty(value = "numberChair")
        open var numberOfChairs: Int = 0,

        @Column(name = "projector")
        @JsonProperty(value = "project")
        open var hasProjector: Boolean = false,

        @Column(name = "board")
        @JsonProperty(value = "board")
        open var hasBoard: Boolean = false,

        @Column(name = "smart_board")
        @JsonProperty(value = "smartBoard")
        open var hasSmartBoard: Boolean = false,

        val type: SpaceTypeEnum = SpaceTypeEnum.CLASSROOM,

        @OneToMany(targetEntity = SchedulingModel::class)
        @JsonIgnoreProperties
        val schedulingModels: MutableList<SchedulingModel> = mutableListOf()

) {

    override fun toString(): String {
        return "SpaceModel(id=$id, name='$name', numberOfChairs=$numberOfChairs, hasProjector=$hasProjector, " +
                "hasBoard=$hasBoard, hasSmartBoard=$hasSmartBoard, spaceType=$type, " +
                "schedulingModels=$schedulingModels)"
    }

}