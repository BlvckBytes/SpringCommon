package me.blvckbytes.springcommon.validation

import kotlin.reflect.KProperty

class NotNullAndNotBlank(
  override val field: KProperty<String?>,
  override val fieldValue: String?
): ApplicableValidator<String> {

  override fun validate(): Boolean {
    return fieldValue != null && fieldValue.isNotBlank()
  }
}