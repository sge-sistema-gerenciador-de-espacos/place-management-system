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

        var city: CityModel = CityModel()

) {

    @Entity(name = "city")
    data class CityModel(
            @Id
            @SequenceGenerator(name = "id", sequenceName = "city_id_seq",
                    allocationSize = 1)
            @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
            var id: Long = 0,
            var name: String = "", var initials: String = "", var state: StateModel = StateModel())

    @Entity(name = "state")
    data class StateModel(
            @Id
            @SequenceGenerator(name = "id", sequenceName = "state_id_seq",
                    allocationSize = 1)
            @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
            var id: Long = 0,
            var name: String = "", var initials: String = "", var state: CountryModel = CountryModel())

    @Entity(name = "country")
    data class CountryModel(
            @Id
            @SequenceGenerator(name = "id", sequenceName = "country_id_seq",
                    allocationSize = 1)
            @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
            var id: Long = 0,
            var name: String = "", var initials: String = "")
}

