package me.blvckbytes.springcommon.exception

abstract class DescribedException : RuntimeException() {

  companion object {
    fun fromDescription(description: String): DescribedException {
      return object : DescribedException() {
        override fun getDescription(): String {
          return description
        }
      }
    }
  }

  abstract fun getDescription(): String

}