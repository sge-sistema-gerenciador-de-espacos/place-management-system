package com.pms.placemanagementsystemserverside.repository.contract

interface Repository<T> {
    fun add(item: T)

    fun update(item: T)

    fun remove(item: T)

    fun query(criteria: Criteria): List<T>
}