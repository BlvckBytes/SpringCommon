package me.blvckbytes.springcommon.config

import me.blvckbytes.springcommon.absentable.AbsentableNullableJsonDeserializer
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ObjectMapperAbsentableConfig {

  @Bean
  open fun jsonCustomizer(): Jackson2ObjectMapperBuilderCustomizer? {
    return Jackson2ObjectMapperBuilderCustomizer {
      it.deserializers(AbsentableNullableJsonDeserializer())
    }
  }
}