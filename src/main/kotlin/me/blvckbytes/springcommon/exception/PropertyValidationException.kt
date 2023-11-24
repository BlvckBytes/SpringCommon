package me.blvckbytes.springcommon.exception

import me.blvckbytes.springcommon.config.ApiError
import me.blvckbytes.springcommon.config.ApiFieldValidationError
import org.springframework.http.HttpStatus

class PropertyValidationException : ApiErrorException() {

  private val results = mutableListOf<ApiFieldValidationError>()

  fun addResult(result: ApiFieldValidationError?): PropertyValidationException {
    if (result != null)
      results.add(result)
    return this
  }

  fun throwIfApplicable() {
    if (results.isNotEmpty())
      throw this
  }

  override fun getApiError(): ApiError {
    return ApiError(
      HttpStatus.BAD_REQUEST,
      "The provided data did not pass validation",
      results
    )
  }
}