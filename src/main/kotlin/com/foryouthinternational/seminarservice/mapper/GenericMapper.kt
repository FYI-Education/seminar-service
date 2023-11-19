package com.foryouthinternational.seminarservice.mapper

interface GenericMapper<E, D> {
    fun toEntity(dto: D): E
    fun toDto(entity: E): D
}