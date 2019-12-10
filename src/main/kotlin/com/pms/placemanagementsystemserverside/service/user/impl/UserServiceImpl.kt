package com.pms.placemanagementsystemserverside.service.user.impl

import com.pms.placemanagementsystemserverside.dto.ProfessorLackPostRequest
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.repository.user.UserRepository
import com.pms.placemanagementsystemserverside.service.space.SpaceService
import com.pms.placemanagementsystemserverside.service.user.UserService
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var spaceService: SpaceService

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
        if (userModel.status == ActivationModelStatusEnum.INACTIVE) {
            val date = DateTimeFormat.forPattern("yyyy-MM-dd").print(DateTime())
            userModel.evasionDate = date
        }
        userRepository.update(userModel)
    }

    override fun delete(id: Long) {
        userRepository.delete(id)
    }

    override fun professorLack(professorLackPostRequest: ProfessorLackPostRequest) {
        val professor = userRepository.read().find { it.id == professorLackPostRequest.professorId }!!
        spaceService.read().forEach { space ->
            space.schedulingModels.forEach { scheduling ->
                if (professor.id == scheduling.professor?.id) {
                    scheduling.schedulingDateModels.forEach {
                        if (it.date == professorLackPostRequest.date) {
                            it.status = ActivationModelStatusEnum.INACTIVE
                        }
                    }
                }
            }
        }

        professor.professorLack = professorLackPostRequest.date
    }
}