package me.blvckbytes.springcommon.absentable

class AbsentableNullable<T : Any> private constructor(
  val value: T?,
  override val absent: Boolean
) : Absentable {

  companion object {
    fun <T : Any> of(value: T?): AbsentableNullable<T> {
      return AbsentableNullable(value, false)
    }

    fun absent(): AbsentableNullable<*> {
      return AbsentableNullable(null, true)
    }
  }

  fun asNotNull(): AbsentableNotNull<T> {
    if (absent)
      return AbsentableNotNull.absent()

    return AbsentableNotNull.of(
      value ?: throw IllegalStateException("Internal value was null")
    )
  }

  inline fun getIfPresent(receiver: (value: T?) -> Unit) {
    if (absent)
      return

    receiver(value)
  }

  override fun toString(): String {
    return if (absent) "<absent>" else value?.toString() ?: "<null>"
  }
}