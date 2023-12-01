package me.blvckbytes.springcommon.validation

import kotlin.reflect.KProperty

interface Validator<T> {
  val field: KProperty<T?>
  val fieldValue: T?
}