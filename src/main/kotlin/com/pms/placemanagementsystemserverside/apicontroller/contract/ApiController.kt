package com.pms.placemanagementsystemserverside.apicontroller.contract

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface ApiController<T> {

    @PostMapping
    fun create(@RequestBody item: T): ResponseEntity<Unit>

    @PostMapping(value = ["/filter"])
    fun readByFilter(@RequestBody item: T): ResponseEntity<List<T>>

    @GetMapping
    fun read(): ResponseEntity<List<T>>

    @PutMapping
    fun update(@RequestBody item: T): ResponseEntity<T>

    @DeleteMapping
    fun delete(@PathVariable id: Long): ResponseEntity<Unit>
}