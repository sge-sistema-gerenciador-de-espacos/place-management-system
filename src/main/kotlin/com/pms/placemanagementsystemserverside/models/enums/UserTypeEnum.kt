package com.pms.placemanagementsystemserverside.models.enums

enum class UserTypeEnum(val value: String) {
    UNKNOWN("UNKNOWN"), PROFESSOR("PROFESSOR"), ASSISTANT("ASSISTANT"),
    ADMINISTRATOR("ADMINISTRATOR"), MANAGER("MANAGER"),
    IT_SUPPORT("IT_SUPPORT"), STUDENT("STUDENT")
}