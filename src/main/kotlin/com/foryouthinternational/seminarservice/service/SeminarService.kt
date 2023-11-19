package com.foryouthinternational.seminarservice.service

import com.foryouthinternational.seminarservice.dto.SeminarDto
import com.foryouthinternational.seminarservice.entity.Seminar

interface SeminarService : GenericCrudService<Seminar, SeminarDto, Long> {
    fun findAllByOrderByCreatedAtDesc(): List<Seminar>
}