package me.blvckbytes.springcommon.validation

import me.blvckbytes.springcommon.config.ApiFieldValidationError
import kotlin.reflect.KProperty

object CompareToMinMax {

  fun <T : Comparable<T>> validate(
    self: KProperty<T?>, selfValue: T?,
    min: T, max: T
  ): ApiFieldValidationError? {
    if (selfValue == null)
      return null

    if (selfValue >= min && selfValue <= max)
      return null

    return ApiFieldValidationError(
      self.name,
      selfValue,
      "Must be between $min and $max"
    )
  }
}