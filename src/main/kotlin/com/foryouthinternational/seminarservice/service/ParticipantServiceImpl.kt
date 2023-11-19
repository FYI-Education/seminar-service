package com.foryouthinternational.seminarservice.service

import com.foryouthinternational.seminarservice.dto.ParticipantDto
import com.foryouthinternational.seminarservice.entity.Participant
import com.foryouthinternational.seminarservice.mapper.ParticipantMapper
import com.foryouthinternational.seminarservice.repository.ParticipantRepository
import com.foryouthinternational.seminarservice.util.AppConstants
import com.foryouthinternational.seminarservice.util.ErrorMessages
import com.foryouthinternational.seminarservice.util.SuccessMessages
import jakarta.persistence.EntityNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ParticipantServiceImpl(
    private val participantRepository: ParticipantRepository,
    private val participantMapper: ParticipantMapper
) : ParticipantService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun findAllBySeminarId(seminarId: Long): List<Participant> =
        participantRepository.findAllBySeminarId(seminarId)

    override fun save(dto: ParticipantDto): Participant {
        val participant = participantMapper.toEntity(dto)
        val savedParticipant = participantRepository.save(participant)

        logger.info(
            String.format(SuccessMessages.SAVED_SUCCESS_TEMPLATE, AppConstants.PARTICIPANT, savedParticipant.id)
        )
        return savedParticipant
    }

    override fun findById(id: Long): Participant =
        participantRepository.findById(id).orElseThrow {
            EntityNotFoundException(
                String.format(ErrorMessages.ENTITY_NOT_FOUND_TEMPLATE, AppConstants.PARTICIPANT, id)
            )
        }

    override fun findAll(): List<Participant> {
        TODO("Not yet implemented")
    }

    override fun update(dto: ParticipantDto): Participant {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

}