package me.blvckbytes.springcommon.absentable

class AbsentableNullable<T : Any> private constructor(
  val value: T?,
  override val absent: Boolean
) : Absentable {

  companion object {
    val ABSENT = AbsentableNullable(null, true)
    val NULL = AbsentableNullable(null, false)

    fun <T : Any> of(value: T?): AbsentableNullable<T> {
      if (value == null) {
        @Suppress("UNCHECKED_CAST")
        return NULL as AbsentableNullable<T>
      }

      return AbsentableNullable(value, false)
    }
  }

  fun asNotNull(): AbsentableNotNull<T> {
    if (absent) {
      @Suppress("UNCHECKED_CAST")
      return AbsentableNotNull.ABSENT as AbsentableNotNull<T>
    }

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