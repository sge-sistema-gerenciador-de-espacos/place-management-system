package com.pms.placemanagementsystemserverside.repository.contract

interface Repository<T> {
    fun create(item: T)
    fun read(item: T): List<T>
    fun update(item: T)
    fun delete(item: T)
}