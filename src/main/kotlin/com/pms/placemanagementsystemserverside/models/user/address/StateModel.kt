package com.pms.placemanagementsystemserverside.models.user.address

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*


@Entity(name = "state")
data class StateModel(
        @Id
        @SequenceGenerator(name = "id", sequenceName = "state_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        var id: Long = 0,

        @JsonIgnoreProperties
        var name: String = "",

        @JsonIgnoreProperties
        var initials: String = "",

        @OneToOne(targetEntity = CountryModel::class)
        @JsonIgnoreProperties
        var countryModel: CountryModel = CountryModel()
)