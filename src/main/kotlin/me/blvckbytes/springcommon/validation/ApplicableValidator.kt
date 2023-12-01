package me.blvckbytes.springcommon.validation

interface ApplicableValidator<T> : Validator<T> {
  fun validate(): Boolean
}