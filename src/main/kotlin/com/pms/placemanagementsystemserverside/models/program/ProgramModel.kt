package com.pms.placemanagementsystemserverside.models.program

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.util.json.parse.program.ProgramDeserialize
import com.pms.placemanagementsystemserverside.util.json.parse.program.ProgramSerialize
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "program")
@JsonSerialize(using = ProgramSerialize::class)
@JsonDeserialize(using = ProgramDeserialize::class)
data class ProgramModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        var name: String? = null,

        var code: String? = null,

        var status: ActivationModelStatusEnum? = null
)