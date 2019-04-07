package com.pms.placemanagementsystemserverside.apicontroller

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/pms-api"])
abstract class BaseApiController<T> : ApiController<T>