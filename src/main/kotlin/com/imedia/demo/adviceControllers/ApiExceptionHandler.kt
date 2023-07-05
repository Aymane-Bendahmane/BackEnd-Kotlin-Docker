package com.imedia.demo.adviceControllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*

/**
 * Global exception handler for handling exceptions in API controllers.
 */
@ControllerAdvice
class ApiExceptionHandler {
    private val logger: Logger = LoggerFactory.getLogger(ApiExceptionHandler::class.java)

    /**
     * Exception handler for NoSuchElementException.
     *
     * @param ex the NoSuchElementException to handle
     * @return a ResponseEntity with a message and HTTP status code NOT_FOUND
     */
    @ExceptionHandler(NoSuchElementException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<String> {
        logger.error("Resource not found: $ex")
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found")
    }

    /**
     * Exception handler for generic exceptions.
     *
     * @param ex the Exception to handle
     * @return a ResponseEntity with a message and HTTP status code INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(ex: Exception): ResponseEntity<String> {
        logger.error("Technical problem: $ex")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Technical Problem")
    }
}
