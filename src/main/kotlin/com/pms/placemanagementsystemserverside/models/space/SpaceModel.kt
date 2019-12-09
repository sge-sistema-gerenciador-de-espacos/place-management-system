package com.pms.placemanagementsystemserverside.models.space

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
import com.pms.placemanagementsystemserverside.util.json.parse.space.SpaceDeserializer
import com.pms.placemanagementsystemserverside.util.json.parse.space.SpaceSerializer
import javax.persistence.*

@Entity(name = "space")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonSerialize(using = SpaceSerializer::class)
@JsonDeserialize(using = SpaceDeserializer::class)
data class SpaceModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "space_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        var id: Long = 0,

        var name: String = "",

        @Column(name = "number_chair")
        var numberOfChairs: Int = 0,

        @Column(name = "projector")
        var hasProjector: Boolean = false,

        @Column(name = "board")
        var hasBoard: Boolean = false,

        @Column(name = "smart_board")
        var hasSmartBoard: Boolean = false,

        var type: SpaceTypeEnum = SpaceTypeEnum.UNKNOWN,

        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN,

        @OneToMany(targetEntity = SchedulingModel::class)
        @JsonIgnoreProperties
        val schedulingModels: MutableList<SchedulingModel> = mutableListOf(),

        @Column(name = "number_pc")
        @JsonProperty(value = "numberPc")
        var numberOfPcs: Int = 0,

        @ManyToMany(targetEntity = SoftwareModel::class)
        var softwares: List<SoftwareModel> = mutableListOf()
) {

    fun extraConditionToFilterSpaceIntention(anotherSpace: SpaceModel): Boolean {
        return when (this.type) {
            SpaceTypeEnum.CLASSROOM -> this.numberOfChairs >= anotherSpace.numberOfChairs
            SpaceTypeEnum.COMPUTER_LAB -> this.numberOfPcs >= anotherSpace.numberOfPcs
            else -> throw IllegalArgumentException(
                    "Error in SpaceMode::extraConditionToFilterSpaceIntention"
            )
        }
    }

}
