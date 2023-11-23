package com.foryouthinternational.seminarservice.service

import com.foryouthinternational.seminarservice.dto.ParticipantDto
import com.foryouthinternational.seminarservice.entity.Participant

interface ParticipantService : GenericCrudService<Participant, ParticipantDto, Long> {
    fun findAllBySeminarId(seminarId: Long): List<Participant>
    suspend fun sendNotifRegistry(participant: ParticipantDto)
}