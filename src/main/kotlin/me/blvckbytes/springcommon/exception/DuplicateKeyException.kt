package me.blvckbytes.springcommon.exception

abstract class DuplicateKeyException(
  private val displayName: String,
  identifiers: Map<String, Any>
) : IdentifierMapException(identifiers) {

  override fun getDescription(): String {
    return "The entity $displayName with keys $identifiersRepresentation already exists"
  }
}