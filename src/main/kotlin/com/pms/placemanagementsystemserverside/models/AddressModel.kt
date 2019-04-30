package com.pms.placemanagementsystemserverside.models

import javax.persistence.*

@Entity(name = "addresses")
class AddressModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "address_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        var id: Long = 0,

        var neighborhood: String = "",

        var number: Int = 0,

        var complement: String = "",

        var street: String = "",

        var city: CityModel = CityModel()

) {
    override fun toString() = "AddressModel(id=$id, neighborhood='$neighborhood', number=$number, " +
            "complement='$complement', street='$street', city=$city)"


    @Entity(name = "city")
    class CityModel(
            @Id
            @SequenceGenerator(name = "id", sequenceName = "city_id_seq",
                    allocationSize = 1)
            @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
            var id: Long = 0,
            var name: String = "", var initials: String = "", var state: StateModel = StateModel()) {

        override fun toString() = "CityModel(id='$id', name='$name', initials='$initials', state=$state)"
    }

    @Entity(name = "state")
    class StateModel(
            @Id
            @SequenceGenerator(name = "id", sequenceName = "state_id_seq",
                    allocationSize = 1)
            @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
            var id: Long = 0,
            var name: String = "", var initials: String = "", var state: CountryModel = CountryModel()) {

        override fun toString() = "StateModel(id='$id', name='$name', initials='$initials', state=$state)"
    }

    @Entity(name = "country")
    class CountryModel(
            @Id
            @SequenceGenerator(name = "id", sequenceName = "country_id_seq",
                    allocationSize = 1)
            @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
            var id: Long = 0,
            var name: String = "", var initials: String = "") {

        override fun toString() = "CountryModel(id='$id', name='$name', initials='$initials')"
    }

}

