package me.blvckbytes.springcommon.validation

import me.blvckbytes.springcommon.config.ApiFieldValidationError
import kotlin.reflect.KProperty

object NullOrNotBlank {

  fun validate(property: KProperty<String?>, value: String?): ApiFieldValidationError? {
    if (value == null)
      return null

    if (value.isNotBlank())
      return null

    return ApiFieldValidationError(
      property.name,
      value,
      "Must be either null or not blank"
    )
  }
}