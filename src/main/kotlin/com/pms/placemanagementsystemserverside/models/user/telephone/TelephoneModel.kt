package com.pms.placemanagementsystemserverside.models.user.telephone

import javax.persistence.*

@Entity(name = "telephones")
data class TelephoneModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "telephones_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        var id: Long = 0,

        var code: Int = 0,

        var number: Int = 0
)