package com.foryouthinternational.seminarservice.service

import com.foryouthinternational.seminarservice.dto.SeminarDto
import com.foryouthinternational.seminarservice.entity.Seminar
import com.foryouthinternational.seminarservice.mapper.SeminarMapper
import com.foryouthinternational.seminarservice.repository.SeminarRepository
import com.foryouthinternational.seminarservice.util.AppConstants
import com.foryouthinternational.seminarservice.util.ErrorMessages
import com.foryouthinternational.seminarservice.util.SuccessMessages
import jakarta.persistence.EntityNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SeminarServiceImpl(
    private val seminarRepository: SeminarRepository,
    private val seminarMapper: SeminarMapper
) : SeminarService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun findAllByOrderByCreatedAtDesc(): List<Seminar> =
        seminarRepository.findAllByOrderByCreatedAtDesc()

    override fun save(dto: SeminarDto): Seminar {
        val seminar = seminarMapper.toEntity(dto)
        val savedSeminar = seminarRepository.save(seminar)

        logger.info(
            String.format(SuccessMessages.SAVED_SUCCESS_TEMPLATE, AppConstants.SEMINAR, savedSeminar.id)
        )
        return savedSeminar
    }

    override fun findById(id: Long): Seminar =
        seminarRepository.findById(id).orElseThrow {
            EntityNotFoundException(
                String.format(ErrorMessages.ENTITY_NOT_FOUND_TEMPLATE, AppConstants.SEMINAR, id)
            )
        }

    override fun findAll(): List<Seminar> = seminarRepository.findAll()

    override fun update(dto: SeminarDto): Seminar {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}