package com.foryouthinternational.seminarservice.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class ParticipantDto(
    @field:NotBlank(message = "Participant name must not be blank.")
    val name: String,

    @field:Email(message = "Invalid email format.")
    val email: String,

    @field:NotBlank(message = "Phone number must not be blank")
    @field:Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Invalid phone number format")
    val phoneNumber: String,

    val seminarId: Long
)
