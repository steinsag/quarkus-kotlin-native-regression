package com.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.quarkus.jackson.ObjectMapperCustomizer
import jakarta.inject.Singleton

@Singleton
class ObjectMapperConfiguration :ObjectMapperCustomizer{
    override fun customize(objectMapper: ObjectMapper) {
        objectMapper.registerModules(KotlinModule.Builder().build())
    }
}
