package com.pms.placemanagementsystemserverside.apicontroller.contract

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface ApiController<T> {

    @PostMapping
    fun createResource(@RequestBody item: T): ResponseEntity<Unit>

    @PostMapping(value = ["/filter"])
    fun selectResourcesByFilter(@RequestBody item: T): ResponseEntity<List<T>>

    @GetMapping
    fun selectAllResources(): ResponseEntity<List<T>>

    @PutMapping
    fun updateResource(@RequestBody item: T): ResponseEntity<T>

    @DeleteMapping
    fun deleteResource(@PathVariable id: Long): ResponseEntity<Unit>
}