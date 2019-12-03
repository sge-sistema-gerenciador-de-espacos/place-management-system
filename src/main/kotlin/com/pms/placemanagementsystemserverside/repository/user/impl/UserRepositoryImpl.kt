package com.pms.placemanagementsystemserverside.repository.user.impl

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.repository.user.UserJpaRepository
import com.pms.placemanagementsystemserverside.repository.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Repository


@Repository
class UserRepositoryImpl : UserRepository {

    @Autowired
    private lateinit var userJpaRepository: UserJpaRepository

    override fun create(user: UserModel): UserModel {
        return userJpaRepository.saveAndFlush(user)
    }

    override fun read(): List<UserModel> {
        return userJpaRepository.findAll()
    }

    override fun update(user: UserModel): UserModel {
        return if (userJpaRepository.findById(user.id ?: 0).isPresent) {
            userJpaRepository.saveAndFlush(user)
        } else {
            UserModel()
        }
    }

    override fun delete(id: Long) {
        val existingUser = userJpaRepository.findById(id)
        userJpaRepository.delete(existingUser.get())
    }
}