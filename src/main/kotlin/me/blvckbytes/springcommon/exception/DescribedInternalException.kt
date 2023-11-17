package me.blvckbytes.springcommon.exception

class DescribedInternalException(
  private val description: String,
  val occurredException: java.lang.Exception?
) : DescribedException() {

  constructor(description: String): this(description, null)

  override fun getDescription(): String {
    return description
  }
}
