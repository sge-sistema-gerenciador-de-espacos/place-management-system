package com.pms.placemanagementsystemserverside.models.authenticator

data class AuthenticatorRequestModel(
        var user: String = "",
        var password: String = ""
)