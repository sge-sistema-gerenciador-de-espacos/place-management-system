package com.pms.placemanagementsystemserverside.models.program

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "program")
data class ProgramModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var name: String = "",

        var code: String = "",

        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN
)