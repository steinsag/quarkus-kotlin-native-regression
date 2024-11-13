package com.example.dto

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class EmptyDto(
    val values: Map<String, String>
)
