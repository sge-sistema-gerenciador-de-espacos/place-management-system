package com.pms.placemanagementsystemserverside.models.user

import com.pms.placemanagementsystemserverside.models.AddressModel
import com.pms.placemanagementsystemserverside.models.enums.TypeOfUserEnum
import com.pms.placemanagementsystemserverside.models.enums.UserStatusEnum
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

        open var address: AddressModel = AddressModel(),

        open var status: UserStatusEnum = UserStatusEnum.UNKNOWN,

        @Column(name = "type")
        open var typeOfUser: TypeOfUserEnum = TypeOfUserEnum.UNKNOWN

) {
    override fun toString(): String {
        return "UserModel(id=$id, name='$name', email='$email', address=$address, " +
                "status=$status, typeOfUser=$typeOfUser)"
    }
}