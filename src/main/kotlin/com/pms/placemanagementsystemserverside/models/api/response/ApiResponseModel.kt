package com.pms.placemanagementsystemserverside.models.api.response

data class ApiResponseModel(
        var code: Int = 0,
        var data: Any? = null,
        var message: String = ""
)