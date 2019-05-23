package com.pms.placemanagementsystemserverside.models.user.address

import javax.persistence.*

@Entity(name = "city")
data class CityModel(
        @Id
        @SequenceGenerator(name = "id", sequenceName = "city_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        var id: Long = 0,
        var name: String = "",
        var initials: String = "",

        @OneToOne(targetEntity = StateModel::class)
        var state: StateModel = StateModel()
)
