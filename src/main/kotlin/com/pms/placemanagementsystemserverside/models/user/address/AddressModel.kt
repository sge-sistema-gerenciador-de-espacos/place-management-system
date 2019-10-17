package com.pms.placemanagementsystemserverside.models.user.address

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity(name = "addresses")
data class AddressModel(
        @Id
        @SequenceGenerator(name = "id", sequenceName = "addresses_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        @JsonIgnoreProperties
        var id: Long = 0,

        @JsonIgnoreProperties
        var neighborhood: String = "",

        var number: Int = 0,

        @JsonIgnoreProperties
        var complement: String = "",

        var street: String = "",

        var city: String = "",

        @ManyToOne(targetEntity = StateModel::class)
        var state: StateModel = StateModel()
)

