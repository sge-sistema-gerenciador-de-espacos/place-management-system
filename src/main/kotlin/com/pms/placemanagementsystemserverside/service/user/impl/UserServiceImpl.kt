package com.pms.placemanagementsystemserverside.service.user.impl

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.repository.user.UserRepository
import com.pms.placemanagementsystemserverside.service.user.UserService
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun create(userModel: UserModel): UserModel {
        return userRepository.create(userModel)
    }

    override fun read(): List<UserModel> {
        return userRepository.read()
    }

    override fun readActiveByType(userTypeEnum: UserTypeEnum): List<UserModel> {
        return read().filter {
            it.type == userTypeEnum && it.status == ActivationModelStatusEnum.ACTIVE
        }
    }

    override fun update(userModel: UserModel) {
        if(userModel.status == ActivationModelStatusEnum.INACTIVE) {
            DateTimeFormat.forPattern("YY")
//            user.
        }
        userRepository.update(userModel)
    }

    override fun delete(id: Long) {
        userRepository.delete(id)
    }
}