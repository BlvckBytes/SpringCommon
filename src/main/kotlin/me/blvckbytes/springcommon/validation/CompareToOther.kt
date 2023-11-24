package me.blvckbytes.springcommon.validation

import me.blvckbytes.springcommon.config.ApiFieldValidationError
import kotlin.reflect.KProperty

object CompareToOther {

  fun <T> validate(
    self: KProperty<T?>, selfValue: T?,
    other: KProperty<T?>, otherValue: T?,
    comparison: Comparison
  ): ApiFieldValidationError? where T : Comparable<T> {
    if (selfValue == null || otherValue == null)
      return null

    if (comparison.apply(selfValue, otherValue))
      return null

    return ApiFieldValidationError(
      self.name,
      selfValue,
      "Must be ${comparison.messagePart} ${other.name} (${otherValue})"
    )
  }
}