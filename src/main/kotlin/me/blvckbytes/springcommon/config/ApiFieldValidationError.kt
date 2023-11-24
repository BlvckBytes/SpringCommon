package me.blvckbytes.springcommon.config

class ApiFieldValidationError(
  val name: String,
  val rejectedValue: Any?,
  val message: String
) : ApiSubError(ApiSubErrorType.VALIDATION)