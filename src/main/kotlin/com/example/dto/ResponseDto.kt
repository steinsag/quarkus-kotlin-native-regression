package com.example.dto

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class ResponseDto(
    val messages: List<String> = emptyList()
)
