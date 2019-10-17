package com.pms.placemanagementsystemserverside.models.user.telephone

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity(name = "telephones")
data class TelephoneModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "telephones_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        @JsonIgnoreProperties
        var id: Long = 0,

        @JsonIgnoreProperties
        var code: Int = 0,

        var number: Int = 0
)