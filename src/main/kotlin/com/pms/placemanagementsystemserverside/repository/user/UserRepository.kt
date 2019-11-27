package com.pms.placemanagementsystemserverside.repository.user

import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.models.user.UserModel

interface UserRepository {
    fun create(user: UserModel): UserModel
    fun read(): List<UserModel>
    fun readActivatedUserByType(userTypeEnum: UserTypeEnum): List<UserModel>
    fun update(user: UserModel): UserModel
    fun delete(id: Long)
}