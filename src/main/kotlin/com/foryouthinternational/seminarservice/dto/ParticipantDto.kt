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

    val seminarId: Long,

    @field:NotBlank(message = "Address must not be blank")
    val address: String,

    @field:NotBlank(message = "companyName must not be blank")
    val companyName: String,

    @field:NotBlank(message = "businessCategoryOwned must not be blank")
    val businessCategoryOwned: String,

    @field:NotBlank(message = "productOwned must not be blank")
    val productOwned: String,

    val exportExperience: Boolean,

    @field:NotBlank(message = "reason must not be blank")
    val reason: String,

    @field:NotBlank(message = "resources must not be blank")
    val resources: String,
)
