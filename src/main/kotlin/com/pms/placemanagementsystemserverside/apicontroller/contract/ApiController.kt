package com.pms.placemanagementsystemserverside.apicontroller.contract

import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import org.springframework.web.bind.annotation.*

interface ApiController<T> {

    @PostMapping
    fun create(@RequestBody item: T): ApiResponseModel

    @PostMapping(value = ["/filter"])
    fun readByFilter(@RequestBody item: T): ApiResponseModel

    @GetMapping
    fun read(): ApiResponseModel

    @PutMapping(value = ["/{id}"])
    fun update(@RequestBody item: T, @PathVariable id: Long): ApiResponseModel

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: Long): ApiResponseModel
}