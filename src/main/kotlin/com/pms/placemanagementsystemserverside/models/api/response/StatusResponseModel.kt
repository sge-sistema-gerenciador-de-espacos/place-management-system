package com.pms.placemanagementsystemserverside.models.api.response

data class StatusResponseModel(private val status: StatusResponseTypeEnum) {
    enum class StatusResponseTypeEnum { SUCCESS, ERROR } //TODO colocar o caso de erro para os eps
}
