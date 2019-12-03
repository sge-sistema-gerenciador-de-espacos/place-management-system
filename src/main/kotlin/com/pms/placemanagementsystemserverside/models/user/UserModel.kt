package com.pms.placemanagementsystemserverside.models.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.util.json.parse.user.UserDeserializer
import com.pms.placemanagementsystemserverside.util.json.parse.user.UserSerializer
import javax.persistence.*

@Entity(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonSerialize(using = UserSerializer::class)
@JsonDeserialize(using = UserDeserializer::class)
open class UserModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "user_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        @JsonIgnoreProperties(allowGetters = true)
        open var id: Long = 0,

        open var name: String = "",

        open var email: String = "",

        open var number: Int = 0,

        open var street: String = "",

        open var neighborhood: String = "",

        open var city: String = "",

        open var state: Int = 0,

        open var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN,

        open var type: UserTypeEnum = UserTypeEnum.UNKNOWN,

        open var telephone: String = "",

        open var password: String = ""

) {
    override fun toString(): String =
            "UserModel(id=$id, name=$name, email=$email, number=$number, street=$street, neighborhood=$neighborhood, " +
                    "city=$city, state=$state, status=$status, type=$type, telephone=$telephone, password=$password)"
}