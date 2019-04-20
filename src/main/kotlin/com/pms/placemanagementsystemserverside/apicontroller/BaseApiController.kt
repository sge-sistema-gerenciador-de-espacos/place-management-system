package com.pms.placemanagementsystemserverside.apicontroller

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping(consumes = ["application/json"],
        produces = ["application/json"])
abstract class BaseApiController<T> : ApiController<T>