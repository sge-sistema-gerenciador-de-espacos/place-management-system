package com.pms.placemanagementsystemserverside.models.enums

enum class UserTypeEnum(val value: String) {
    UNKNOWN("Unknown"), PROFESSOR("Professor"), ASSISTANT("Auxiliar"), ADMINISTRATOR("Admin"), MANAGER("Gerenciador"),
    IT_SUPPORT("TI"), STUDENT("Aluno")
}