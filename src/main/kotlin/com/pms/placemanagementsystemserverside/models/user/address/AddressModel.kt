package com.pms.placemanagementsystemserverside.models.user.address

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity(name = "addresses")
data class AddressModel(
        @Id
        @SequenceGenerator(name = "id", sequenceName = "addresses_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        @JsonIgnoreProperties
        var id: Long = 0,

        var number: Int = 0,

        var street: String = "",

        var city: String = "",

        var state: Int
)

