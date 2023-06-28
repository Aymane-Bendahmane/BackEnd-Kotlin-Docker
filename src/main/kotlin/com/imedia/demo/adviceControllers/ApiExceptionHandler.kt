package com.imedia.demo.adviceControllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*


@ControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(*[NoSuchElementException::class])
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found")
    }


    @ExceptionHandler(*[Exception::class])
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(ex: Exception): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Technical Problem")
    }


}