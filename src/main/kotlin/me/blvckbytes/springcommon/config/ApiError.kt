package me.blvckbytes.springcommon.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.time.LocalDateTime

class ApiError(
  val status: HttpStatus,
  val message: String,
  val subErrors: List<ApiSubError> = listOf(),
  val timestamp: LocalDateTime = LocalDateTime.now(),
) {

  fun toResponseEntity(): ResponseEntity<Any> {
    return ResponseEntity(this, status)
  }
}