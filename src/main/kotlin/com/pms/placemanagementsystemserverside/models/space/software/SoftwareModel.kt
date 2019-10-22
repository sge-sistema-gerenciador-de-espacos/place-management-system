package com.pms.placemanagementsystemserverside.models.space.software

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "software")
data class SoftwareModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var name: String = "",

        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN
)