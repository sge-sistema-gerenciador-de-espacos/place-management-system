package com.pms.placemanagementsystemserverside.models.user

import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class StudentModel(

        override var id: Long = 0,
        override var name: String = "",
        override var email: String = "",
        override var number: Int = 0,
        override var street: String = "",
        override var neighborhood: String = "",
        override var city: String = "",
        override var state: Int = 0,
        override var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN,
        override var type: UserTypeEnum = UserTypeEnum.STUDENT,
        override var telephone: String = "",
        override var password: String = "",

        @Column(name = "date_evasion")
        var dataEvasion: Date = Date(),

        @Column(name = "")
        var clazzModelList: List<ClazzModel> = mutableListOf()

) : UserModel(
        id = id, name = name, email = email, number = number, street = street, neighborhood = neighborhood,
        city = city, state = state, status = status, type = type, telephone = telephone, password = password
)