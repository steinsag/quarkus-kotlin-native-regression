package com.example

import com.example.dto.EmptyDto
import com.example.dto.ResponseDto
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON

@Path("/")
class ExampleResource (
    private val objectMapper: ObjectMapper
){

    @GET
    @Produces(APPLICATION_JSON)
    @Path("hello-json")
    fun hello(): ResponseDto = objectMapper.readValue("{}", ResponseDto::class.java)

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello-string")
    fun hello2(): String = objectMapper.writeValueAsString(EmptyDto(emptyMap()))
}
