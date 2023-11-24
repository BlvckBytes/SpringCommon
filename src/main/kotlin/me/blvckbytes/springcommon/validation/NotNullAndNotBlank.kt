package me.blvckbytes.springcommon.validation

import me.blvckbytes.springcommon.config.ApiFieldValidationError
import kotlin.reflect.KProperty

object NotNullAndNotBlank {

  fun validate(property: KProperty<String?>, value: String?): ApiFieldValidationError? {
    if (value != null && value.isNotBlank())
      return null

    return ApiFieldValidationError(
      property.name,
      value,
      "Must not be null and not be blank"
    )
  }
}