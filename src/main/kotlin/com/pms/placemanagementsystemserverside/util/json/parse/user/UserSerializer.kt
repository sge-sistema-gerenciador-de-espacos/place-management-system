package com.pms.placemanagementsystemserverside.util.json.parse.user

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.models.user.UserModel
import java.io.IOException

class UserSerializer(userModel: Class<UserModel>) : StdSerializer<UserModel>(userModel) {
    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(value: UserModel, jgen: JsonGenerator, provider: SerializerProvider) {
        jgen.writeStartObject()
        jgen.writeNumberField("id", value.id ?: 0)
        jgen.writeStringField("type", value.type?.value ?: "")
        jgen.writeStringField("email", value.email ?: "")
        jgen.writeNumberField("status", value.status?.value ?: 0)
        jgen.writeStringField("name", value.name ?: "")
        jgen.writeStringField("street", value.street ?: "")
        jgen.writeStringField("city", value.city ?: "")
        jgen.writeNumberField("number", value.number ?: 0)
        jgen.writeNumberField("state", value.state ?: 0)
        jgen.writeStringField("telephones", value.telephones ?: "")
        jgen.writeEndObject()
    }
}