package com.pms.placemanagementsystemserverside.models.api.response

data class PutResponseModel(private val status: PutResponseTypeEnum) {
    enum class PutResponseTypeEnum { SUCCESS } //TODO saber o oposto de success
}
