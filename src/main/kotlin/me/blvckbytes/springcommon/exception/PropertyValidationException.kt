package me.blvckbytes.springcommon.exception

import me.blvckbytes.springcommon.validation.Validator

class PropertyValidationException(
  val failedValidators: List<Validator<*>>
) : RuntimeException()