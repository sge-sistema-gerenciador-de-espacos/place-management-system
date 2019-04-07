package com.pms.placemanagementsystemserverside.apicontroller.contract

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

interface ApiController<T> {
    fun post(@RequestBody item: T): ResponseEntity<T>
    fun get(@RequestBody item: T): ResponseEntity<List<T>>
    fun put(@RequestBody item: T): ResponseEntity<T>
    fun delete(@RequestBody item: T): ResponseEntity<T>
}