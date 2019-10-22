package com.pms.placemanagementsystemserverside.models.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.pms.placemanagementsystemserverside.models.enums.UserStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.models.user.address.AddressModel
import com.pms.placemanagementsystemserverside.models.user.telephone.TelephoneModel
import javax.persistence.*

@Entity(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@JsonSerialize(using = UserSerializer::class)
//@JsonDeserialize(using = UserDeserializer::class)
open class UserModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "user_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        @JsonIgnoreProperties(allowGetters = true)
        open var id: Long? = null,

        open var name: String? = null,

        open var email: String? = null,

        @OneToOne(targetEntity = AddressModel::class)
        open var address: AddressModel? = null,

        open var status: UserStatusEnum? = null,

        open var type: UserTypeEnum? = null,

        @OneToMany(targetEntity = TelephoneModel::class)
        open var telephones: MutableList<TelephoneModel>? = null

) {
    override fun toString(): String {
        return "UserModel(id=$id, name='$name', email='$email', addresses=$address, " +
                "status=$status, type=$type, telephones=$telephones)"
    }
}