package com.foryouthinternational.seminarservice.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class SeminarDto(
    @field:NotBlank(message = "Title name must not be blank.")
    val title: String,

    @field:NotBlank(message = "Description must not be blank.")
    @field:Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters.")
    val description: String

)
