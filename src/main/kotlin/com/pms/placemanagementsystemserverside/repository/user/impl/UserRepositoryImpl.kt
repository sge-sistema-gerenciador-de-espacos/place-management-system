package com.pms.placemanagementsystemserverside.repository.user.impl

import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.repository.user.UserJpaRepository
import com.pms.placemanagementsystemserverside.repository.user.UserRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
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
        val existingUser = userJpaRepository.findById(user.id)
        BeanUtils.copyProperties(user, existingUser)
        return userJpaRepository.saveAndFlush(existingUser.get())
    }

    override fun delete(id: Long) {
        val existingUser = userJpaRepository.findById(id)
        userJpaRepository.delete(existingUser.get())
    }
}