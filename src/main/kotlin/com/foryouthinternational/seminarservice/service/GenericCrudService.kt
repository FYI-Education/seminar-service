package com.foryouthinternational.seminarservice.service

interface GenericCrudService<E, D, ID> {
    fun save(dto: D): E
    fun findById(id: ID): E
    fun findAll(): List<E>
    fun update(dto: D): E
    fun deleteById(id: ID)
}