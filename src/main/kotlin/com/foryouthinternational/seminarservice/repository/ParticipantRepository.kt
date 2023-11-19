package com.foryouthinternational.seminarservice.repository

import com.foryouthinternational.seminarservice.entity.Participant
import org.springframework.data.jpa.repository.JpaRepository

interface ParticipantRepository : JpaRepository<Participant, Long> {
    fun findAllBySeminarId(seminarId: Long): List<Participant>
}