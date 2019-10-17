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
        open var id: Long = 0,

        open var name: String = "",

        open var email: String = "",

        @OneToOne(targetEntity = AddressModel::class)
        open var address: AddressModel = AddressModel(),

        open var status: UserStatusEnum = UserStatusEnum.UNKNOWN,

        open var type: UserTypeEnum = UserTypeEnum.UNKNOWN,

        @OneToMany(targetEntity = TelephoneModel::class)
        open var telephones: MutableList<TelephoneModel> = mutableListOf()

) {
    override fun toString(): String {
        return "UserModel(id=$id, name='$name', email='$email', addresses=$address, " +
                "status=$status, type=$type, telephones=$telephones)"
    }
}