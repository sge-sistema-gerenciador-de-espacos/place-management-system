package com.pms.placemanagementsystemserverside.util.json.parse

interface ParseContract<T> {
    fun serialize(from: T): Any
    fun deserialize(from: T): Any
}