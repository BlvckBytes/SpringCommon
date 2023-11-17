package me.blvckbytes.springcommon.validators

import jakarta.validation.Constraint
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [NullOrNotBlankValidator::class])
annotation class NullOrNotBlank(
  val message: String = "{jakarta.validation.constraints.NullOrNotBlank.message}",
  val groups: Array<KClass<Any>> = [],
  val payload: Array<KClass<*>> = []
)