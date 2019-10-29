package com.pms.placemanagementsystemserverside.models.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import javax.persistence.*

@Entity(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
open class UserModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "user_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        @JsonIgnoreProperties(allowGetters = true)
        open var id: Long? = null,

        open var name: String? = null,

        open var email: String? = null,

        open var address: String? = null,

        open var statusActivation: ActivationModelStatusEnum? = null,

        open var type: UserTypeEnum? = null,

        open var telephones: String? = null

) {
    override fun toString(): String {
        return "UserModel(id=$id, name='$name', email='$email', addresses=$address, " +
                "status=$statusActivation, type=$type, telephones=$telephones)"
    }
}