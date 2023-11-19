package com.foryouthinternational.seminarservice.mapper

import com.foryouthinternational.seminarservice.dto.SeminarDto
import com.foryouthinternational.seminarservice.entity.Seminar
import org.springframework.stereotype.Component

@Component
class SeminarMapper : GenericMapper<Seminar, SeminarDto> {
    override fun toEntity(dto: SeminarDto): Seminar = Seminar(
        title = dto.title,
        description = dto.description
    )

    override fun toDto(entity: Seminar): SeminarDto {
        TODO("Not yet implemented")
    }
}