package com.pms.placemanagementsystemserverside.models.space

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class SoftwareModel(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @get: NotBlank
        var name: String = ""
)