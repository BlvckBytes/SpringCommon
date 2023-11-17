package me.blvckbytes.springcommon.validators

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class MinMaxIntValidator : ConstraintValidator<MinMaxInt, Int> {

  private var constraintAnnotation: MinMaxInt? = null

  override fun initialize(constraintAnnotation: MinMaxInt?) {
    this.constraintAnnotation = constraintAnnotation
  }

  override fun isValid(value: Int?, context: ConstraintValidatorContext?): Boolean {
    return value == null || (value >= constraintAnnotation!!.min && value <= constraintAnnotation!!.max)
  }
}