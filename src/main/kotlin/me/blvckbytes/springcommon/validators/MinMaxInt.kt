package me.blvckbytes.springcommon.validators

import jakarta.validation.Constraint
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [MinMaxIntValidator::class])
annotation class MinMaxInt(
  val min: Int,
  val max: Int,
  val message: String = "{jakarta.validation.constraints.MinMaxInt.message}",
  val groups: Array<KClass<Any>> = [],
  val payload: Array<KClass<*>> = [],
)