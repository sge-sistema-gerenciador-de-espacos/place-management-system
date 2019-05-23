package com.pms.placemanagementsystemserverside.apicontroller.authenticator

import com.pms.placemanagementsystemserverside.models.authenticator.AuthenticatorRequestModel
import com.pms.placemanagementsystemserverside.models.authenticator.AuthenticatorResponseModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
        value = ["/pms-api/user/"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class AuthenticatorApiController {

    @PostMapping(value = ["/login"])
    fun login(@RequestBody authenticatorRequestModel: AuthenticatorRequestModel):
            ResponseEntity<AuthenticatorResponseModel> {
        return ResponseEntity.ok(AuthenticatorResponseModel())
    }

}