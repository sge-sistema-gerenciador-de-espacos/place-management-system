package com.pms.placemanagementsystemserverside.models.user.address

import javax.persistence.*

@Entity(name = "country")
data class CountryModel(
        @Id
        @SequenceGenerator(name = "id", sequenceName = "country_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        var id: Long = 0,
        var name: String = "",
        var initials: String = ""
)
