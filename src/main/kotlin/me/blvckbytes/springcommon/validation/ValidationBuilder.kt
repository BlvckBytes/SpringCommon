package me.blvckbytes.springcommon.validation

import me.blvckbytes.springcommon.exception.PropertyValidationException

class ValidationBuilder {

  private val failedValidators = mutableListOf<Validator<*>>()

  fun addValidator(validator: ApplicableValidator<*>): ValidationBuilder {
    if (!validator.validate())
      failedValidators.add(validator)
    return this
  }

  fun throwIfApplicable() {
    if (failedValidators.isNotEmpty())
      throw PropertyValidationException(failedValidators)
  }
}