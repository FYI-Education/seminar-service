package com.foryouthinternational.seminarservice.exception

import com.foryouthinternational.seminarservice.dto.ApiResponse
import com.foryouthinternational.seminarservice.util.ApiResponseBuilder
import com.foryouthinternational.seminarservice.util.ErrorMessages
import jakarta.persistence.EntityNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneralExceptions(ex: Exception): ResponseEntity<ApiResponse<Any>> {
        val apiResponse = ApiResponseBuilder.buildError<Any>(ErrorMessages.GENERAL_ERROR, ex.message)
        return ResponseEntity.internalServerError().body(apiResponse)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<ApiResponse<Map<String, String?>>> {
        logger.error(ErrorMessages.VALIDATION_FAILED, ex)
        val errors = ex.bindingResult.fieldErrors.associate { it.field to it.defaultMessage }
        val apiResponse = ApiResponseBuilder.buildError(ErrorMessages.VALIDATION_FAILED, errors);
        return ResponseEntity.badRequest().body(apiResponse)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleNotFoundException(ex: EntityNotFoundException): ResponseEntity<ApiResponse<Any>> {
        logger.error(ErrorMessages.ENTITY_NOT_FOUND, ex)
        val apiResponse = ApiResponseBuilder.buildError<Any>(ex.message ?: ErrorMessages.ENTITY_NOT_FOUND)
        return ResponseEntity.internalServerError().body(apiResponse)
    }
}