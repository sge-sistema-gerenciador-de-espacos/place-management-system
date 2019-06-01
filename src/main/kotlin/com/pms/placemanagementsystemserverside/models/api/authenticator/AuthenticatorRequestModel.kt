package com.pms.placemanagementsystemserverside.models.api.authenticator

data class AuthenticatorRequestModel(
        var user: String = "",
        var password: String = ""
)