package com.pms.placemanagementsystemserverside.models.space

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.util.json.parse.space.SpaceDeserializer
import com.pms.placemanagementsystemserverside.util.json.parse.space.SpaceSerializer
import javax.persistence.*

@Entity(name = "space")
//TODO acertar essa annotation
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonSerialize(using = SpaceSerializer::class)
@JsonDeserialize(using = SpaceDeserializer::class)
open class SpaceModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "space_id_seq", allocationSize = 1)
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

        open var type: SpaceTypeEnum = SpaceTypeEnum.UNKNOWN,

        open var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN,

        @OneToMany(targetEntity = SchedulingModel::class)
        @JsonIgnoreProperties
        val schedulingModels: MutableList<SchedulingModel> = mutableListOf()
) {

    override fun toString(): String = "SpaceModel(id=$id, name='$name', numberOfChairs=$numberOfChairs, " +
            "hasProjector=$hasProjector, " + "hasBoard=$hasBoard, hasSmartBoard=$hasSmartBoard, " +
            "type=$type, status=$status, " + "schedulingModels=$schedulingModels)"
}