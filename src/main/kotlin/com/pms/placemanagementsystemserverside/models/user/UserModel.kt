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
data class UserModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "user_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        @JsonIgnoreProperties(allowGetters = true)
        var id: Long = 0,

        var name: String = "",

        var email: String = "",

        var number: Int = 0,

        var street: String = "",

        var neighborhood: String = "",

        var city: String = "",

        var state: Int = 0,

        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN,

        var type: UserTypeEnum = UserTypeEnum.UNKNOWN,

        var telephone: String = "",

        var password: String = "",

        var application: String = "",

        var evasionDate: String = ""
)