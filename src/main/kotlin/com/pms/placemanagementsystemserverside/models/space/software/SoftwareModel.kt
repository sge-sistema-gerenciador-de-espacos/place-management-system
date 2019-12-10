package com.pms.placemanagementsystemserverside.models.space.software

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.util.json.parse.software.SoftwareDeserialize
import com.pms.placemanagementsystemserverside.util.json.parse.software.SoftwareSerialize
import javax.persistence.*

@Entity(name = "software")
@JsonSerialize(using = SoftwareSerialize::class)
@JsonDeserialize(using = SoftwareDeserialize::class)
data class SoftwareModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var name: String = "",

        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN

//        @ManyToMany(targetEntity = SpaceModel::class)
//        var computerLabModelList: List<SpaceModel> = mutableListOf()
)