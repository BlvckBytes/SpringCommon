package me.blvckbytes.springcommon.exception

import me.blvckbytes.springcommon.absentable.Absentable

class EmptyPatchException : DescribedException() {

  companion object {
    fun throwIfNonePresent(vararg items: Absentable) {
      if (items.any { !it.absent })
        return

      throw EmptyPatchException()
    }
  }

  override fun getDescription(): String {
    return "Please provide at least one property to patch"
  }
}