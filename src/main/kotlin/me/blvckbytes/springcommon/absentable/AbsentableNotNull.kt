package me.blvckbytes.springcommon.absentable

class AbsentableNotNull<T : Any> private constructor(
  val value: T?,
  override val absent: Boolean
): Absentable {

  companion object {
    fun <T : Any> of(value: T): AbsentableNotNull<T> {
      return AbsentableNotNull(value, false)
    }

    fun <T: Any> absent(): AbsentableNotNull<T> {
      return AbsentableNotNull(null, true)
    }
  }

  inline fun getIfPresent(receiver: (value: T) -> Unit) {
    if (absent)
      return

    receiver(value!!)
  }

  override fun toString(): String {
    return if (absent) "<absent>" else value.toString()
  }
}