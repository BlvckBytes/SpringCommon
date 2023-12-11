package me.blvckbytes.springcommon.absentable

class AbsentableNotNull<T : Any> private constructor(
  val value: T?,
  override val absent: Boolean
): Absentable {

  companion object {
    val ABSENT = AbsentableNotNull(null, true)

    fun <T : Any> of(value: T): AbsentableNotNull<T> {
      return AbsentableNotNull(value, false)
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