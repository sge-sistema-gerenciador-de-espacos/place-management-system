package com.pms.placemanagementsystemserverside

import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.models.user.UserModel

object InstanceMocks {

    fun getUserModelList(): List<UserModel> {
        return listOf(
                UserModel(id = 1, name = "User1", type = UserTypeEnum.ADMINISTRATOR),
                UserModel(id = 2, name = "User2", type = UserTypeEnum.PROFESSOR)
        )
    }

}