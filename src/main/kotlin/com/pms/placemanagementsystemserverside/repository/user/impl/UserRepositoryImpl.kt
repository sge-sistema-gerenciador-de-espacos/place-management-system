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

    fun readByUserType(): List<UserModel> {
        return let {
            mutableListOf<UserModel>().apply {
                addAll(userJpaRepository.findAll(Example.of(UserModel(type = UserTypeEnum.ADMINISTRATOR))))
                addAll(userJpaRepository.findAll(Example.of(UserModel(type = UserTypeEnum.MANAGER))))
            }
        }
    }

    fun readActivatedUserByType(userTypeEnum: UserTypeEnum): List<UserModel> {
        return userJpaRepository.findAll(
                Example.of(UserModel(type = userTypeEnum, status = ActivationModelStatusEnum.ACTIVE))
        )
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