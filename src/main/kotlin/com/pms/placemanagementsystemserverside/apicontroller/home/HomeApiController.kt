package com.pms.placemanagementsystemserverside.apicontroller.home

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeApiController {
    @RequestMapping(value = ["/pms-api"])
    fun home() = "Home"
}