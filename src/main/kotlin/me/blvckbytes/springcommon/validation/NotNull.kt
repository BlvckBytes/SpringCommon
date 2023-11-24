package me.blvckbytes.springcommon.validation

import me.blvckbytes.springcommon.config.ApiFieldValidationError
import kotlin.reflect.KProperty

object NotNull {

  fun validate(property: KProperty<Any?>, value: Any?): ApiFieldValidationError? {
    if (value != null)
      return null

    return ApiFieldValidationError(
      property.name,
      null,
      "Must not be null"
    )
  }
}