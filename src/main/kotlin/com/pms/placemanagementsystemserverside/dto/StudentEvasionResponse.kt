package com.pms.placemanagementsystemserverside.dto

data class StudentEvasionResponse(val total: Int, val studentEvasionList: List<StudentEvasion>) {
    data class StudentEvasion(val name: String, val date_evasion: String)
}

