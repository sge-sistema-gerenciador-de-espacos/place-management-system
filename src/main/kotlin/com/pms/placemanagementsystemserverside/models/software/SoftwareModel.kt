package com.pms.placemanagementsystemserverside.models.space.software

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class SoftwareModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,


        var name: String = ""
)