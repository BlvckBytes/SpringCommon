package me.blvckbytes.springcommon.validators

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NullOrNotBlankValidator : ConstraintValidator<NullOrNotBlank, String> {

  override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
    return value == null || value.trim().isNotEmpty()
  }
}