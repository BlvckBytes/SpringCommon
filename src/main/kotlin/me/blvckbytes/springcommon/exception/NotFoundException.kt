package me.blvckbytes.springcommon.exception

abstract class NotFoundException(
  private val displayName: String,
  identifiers: Map<String, Any>
) : IdentifierMapException(identifiers) {

  override fun getDescription(): String {
    return "The entity $displayName with identifier $identifiersRepresentation could not be located"
  }
}