package com.pms.placemanagementsystemserverside.service.user

import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.models.user.UserModel

interface UserService {
    fun create(userModel: UserModel): UserModel
    fun read(): List<UserModel>
    fun readActiveByType(userTypeEnum: UserTypeEnum): List<UserModel>
    fun update(userModel: UserModel)
    fun delete(id: Long)
}
