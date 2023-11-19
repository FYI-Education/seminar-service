package com.foryouthinternational.seminarservice.mapper

import com.foryouthinternational.seminarservice.dto.ParticipantDto
import com.foryouthinternational.seminarservice.entity.Participant
import com.foryouthinternational.seminarservice.service.SeminarService
import org.springframework.stereotype.Component

@Component
class ParticipantMapper(private val seminarService: SeminarService) : GenericMapper<Participant, ParticipantDto> {

    override fun toEntity(dto: ParticipantDto): Participant {
        val seminar = seminarService.findById(dto.seminarId)
        return Participant(
            name = dto.name,
            email = dto.email,
            seminar = seminar,
            phoneNumber = dto.phoneNumber
        )
    }

    override fun toDto(entity: Participant): ParticipantDto {
        TODO("Not yet implemented")
    }
}