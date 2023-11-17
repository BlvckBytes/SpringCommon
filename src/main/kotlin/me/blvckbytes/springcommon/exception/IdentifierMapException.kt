package me.blvckbytes.springcommon.exception

abstract class IdentifierMapException(
  identifiers: Map<String, Any>
) : DescribedException() {
  protected val identifiersRepresentation = identifiers.entries.joinToString(", ", "(", ")") {
    "${it.key}=${it.value}"
  }
}