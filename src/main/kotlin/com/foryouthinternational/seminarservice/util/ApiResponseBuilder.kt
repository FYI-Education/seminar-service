package com.foryouthinternational.seminarservice.util

import com.foryouthinternational.seminarservice.dto.ApiResponse

object ApiResponseBuilder {
    fun <T> buildSuccess(message: String = "Operation successful", data: T): ApiResponse<T> {
        return ApiResponse(
            success = true,
            message = message,
            data = data
        )
    }

    fun <T> buildError(message: String, data: T? = null): ApiResponse<T> {
        return ApiResponse(
            success = false,
            message = message,
            data = data
        )
    }
}