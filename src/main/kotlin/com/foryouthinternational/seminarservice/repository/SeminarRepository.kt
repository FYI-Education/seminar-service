package com.foryouthinternational.seminarservice.repository

import com.foryouthinternational.seminarservice.entity.Seminar
import org.springframework.data.jpa.repository.JpaRepository

interface SeminarRepository : JpaRepository<Seminar, Long> {
    fun findAllByOrderByCreatedAtDesc(): List<Seminar>
}