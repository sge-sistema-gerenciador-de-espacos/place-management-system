package com.pms.placemanagementsystemserverside.extensions

import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum

fun String.deserializeToUserTypeEnum(): UserTypeEnum =
        when (this) {
            UserTypeEnum.MANAGER.value -> UserTypeEnum.MANAGER
            UserTypeEnum.ADMINISTRATOR.value -> UserTypeEnum.ADMINISTRATOR
            UserTypeEnum.ASSISTANT.value -> UserTypeEnum.ASSISTANT
            UserTypeEnum.IT_SUPPORT.value -> UserTypeEnum.IT_SUPPORT
            UserTypeEnum.PROFESSOR.value -> UserTypeEnum.PROFESSOR
            UserTypeEnum.STUDENT.value -> UserTypeEnum.STUDENT
            else -> UserTypeEnum.UNKNOWN
        }