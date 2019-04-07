package com.pms.placemanagementsystemserverside.apicontroller

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pms-api")
abstract class BaseApiController : ApiController {

    @GetMapping
    fun home() = "HOME TEST"
}