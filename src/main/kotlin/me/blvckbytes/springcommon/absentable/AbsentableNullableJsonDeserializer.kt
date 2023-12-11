package me.blvckbytes.springcommon.absentable

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.BeanProperty
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.deser.ContextualDeserializer
import com.fasterxml.jackson.databind.type.TypeFactory

class AbsentableNullableJsonDeserializer(
  private val type: JavaType = TypeFactory.unknownType()
) : JsonDeserializer<AbsentableNullable<*>>(), ContextualDeserializer {

  override fun deserialize(parser: JsonParser?, context: DeserializationContext?): AbsentableNullable<*> {
    return AbsentableNullable.of(context!!.readValue(parser, type.rawClass))
  }

  override fun getAbsentValue(ctxt: DeserializationContext?): Any {
    return AbsentableNullable.ABSENT
  }

  override fun handledType(): Class<*> {
    return AbsentableNullable::class.java
  }

  override fun createContextual(ctxt: DeserializationContext?, property: BeanProperty?): JsonDeserializer<*> {
    val type = property!!.type.containedType(0)
      ?: throw IllegalStateException("The contained type is crucial to be known")

    if (this.type == type)
      return this

    return AbsentableNullableJsonDeserializer(type)
  }
}