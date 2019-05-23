package com.pms.placemanagementsystemserverside.service.user.impl

import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.repository.user.UserRepository
import com.pms.placemanagementsystemserverside.service.user.UserService
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

    override fun update(userModel: UserModel) {
        userRepository.update(userModel)
    }

    override fun delete(id: Long) {
        userRepository.delete(id)
    }
}