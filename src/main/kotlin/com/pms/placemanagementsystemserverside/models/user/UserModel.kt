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
        open var id: Long? = null,

        open var name: String? = null,

        open var email: String? = null,

        open var number: Int? = null,

        open var street: String? = null,

        open var city: String? = null,

        open var state: Int? = null,

        open var status: ActivationModelStatusEnum? = null,

        open var type: UserTypeEnum? = null,

        open var telephone: String? = null,

        open var password: String? = null

) {
    override fun toString(): String {
        return "UserModel(" +
                "id=$id, name=$name, email=$email, number=$number, street='$street', city='$city', state=$state, " +
                "statusActivation=$status, type=$type, telephone=$telephone, password=$password" +
                ")"
    }
}