package com.pms.placemanagementsystemserverside.models.user.address

import javax.persistence.*

@Entity(name = "addresses")
data class AddressModel(
        @Id
        @SequenceGenerator(name = "id", sequenceName = "addresses_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        var id: Long = 0,

        var neighborhood: String = "",

        var number: Int = 0,

        var complement: String = "",

        var street: String = "",

        var city: String = "",

        @ManyToOne(targetEntity = StateModel::class)
        var state: StateModel = StateModel()
)

