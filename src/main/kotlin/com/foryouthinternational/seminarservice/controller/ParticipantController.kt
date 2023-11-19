package com.foryouthinternational.seminarservice.controller

import com.foryouthinternational.seminarservice.dto.ApiResponse
import com.foryouthinternational.seminarservice.dto.ParticipantDto
import com.foryouthinternational.seminarservice.entity.Participant
import com.foryouthinternational.seminarservice.service.ParticipantService
import com.foryouthinternational.seminarservice.util.ApiResponseBuilder
import com.foryouthinternational.seminarservice.util.AppConstants
import com.foryouthinternational.seminarservice.util.SuccessMessages
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/participants")
class ParticipantController(private val participantService: ParticipantService) {

    @PostMapping
    fun registerParticipant(@RequestBody @Valid participantDto: ParticipantDto): ResponseEntity<ApiResponse<Participant>> {
        val createdParticipant = participantService.save(participantDto)
        val apiResponse = ApiResponseBuilder.buildSuccess(
            message = String.format(
                SuccessMessages.SAVED_SUCCESS_TEMPLATE,
                AppConstants.PARTICIPANT,
                createdParticipant.id
            ),
            data = createdParticipant
        )
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse)
    }
}