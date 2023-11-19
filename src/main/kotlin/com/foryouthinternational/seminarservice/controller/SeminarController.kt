package com.foryouthinternational.seminarservice.controller

import com.foryouthinternational.seminarservice.dto.ApiResponse
import com.foryouthinternational.seminarservice.dto.SeminarDto
import com.foryouthinternational.seminarservice.entity.Seminar
import com.foryouthinternational.seminarservice.service.SeminarService
import com.foryouthinternational.seminarservice.util.ApiResponseBuilder
import com.foryouthinternational.seminarservice.util.AppConstants
import com.foryouthinternational.seminarservice.util.SuccessMessages
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/seminars")
class SeminarController(private val seminarService: SeminarService) {

    @PostMapping
    fun createSeminar(@RequestBody @Valid seminarDto: SeminarDto): ResponseEntity<ApiResponse<Seminar>> {
        val createdSeminar = seminarService.save(seminarDto)
        val apiResponse = ApiResponseBuilder.buildSuccess(
            message = String.format(SuccessMessages.SAVED_SUCCESS_TEMPLATE, AppConstants.SEMINAR, createdSeminar.id),
            data = createdSeminar
        )
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse)
    }

    @GetMapping
    fun getAllSeminars(): ResponseEntity<ApiResponse<List<Seminar>>> {
        val seminars = seminarService.findAll()
        val apiResponse = ApiResponseBuilder.buildSuccess(
            data = seminars
        )
        return ResponseEntity.ok().body(apiResponse)
    }
}