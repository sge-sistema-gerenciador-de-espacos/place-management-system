package com.pms.placemanagementsystemserverside.models.user

import com.pms.placemanagementsystemserverside.models.enums.UserStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.models.user.address.AddressModel
import com.pms.placemanagementsystemserverside.models.user.telephone.TelephoneModel
import javax.persistence.*

@Entity(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
open class UserModel(

        @Id
        @SequenceGenerator(name = "id", sequenceName = "user_id_seq",
                allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        open var id: Long = 0,

        open var name: String = "",

        open var email: String = "",

        @OneToOne(targetEntity = AddressModel::class)
        open var addresses: AddressModel = AddressModel(),

        open var status: UserStatusEnum = UserStatusEnum.UNKNOWN,

        @Column(name = "type")
        open var type: UserTypeEnum = UserTypeEnum.UNKNOWN,

        //TODO acordado que vai ser uma lista
        @OneToMany(targetEntity = TelephoneModel::class)
        open var telephones: MutableList<TelephoneModel> = mutableListOf()

) {
    override fun toString(): String {
        return "UserModel(id=$id, name='$name', email='$email', addresses=$addresses, " +
                "status=$status, type=$type, telephones=$telephones)"
    }
}