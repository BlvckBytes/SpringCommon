package me.blvckbytes.springcommon.validation

import me.blvckbytes.springcommon.config.ApiFieldValidationError
import kotlin.reflect.KProperty

object CompareToConstant {

  fun <T : Comparable<T>> validate(
    self: KProperty<T?>, selfValue: T?,
    constant: T,
    comparison: Comparison
  ): ApiFieldValidationError? {
    if (selfValue == null)
      return null

    if (comparison.apply(selfValue, constant))
      return null

    return ApiFieldValidationError(
      self.name,
      selfValue,
      "Must be ${comparison.messagePart} $constant"
    )
  }
}