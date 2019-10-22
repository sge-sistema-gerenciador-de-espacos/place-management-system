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
//        jgen.writeNumberField("id", value.id ?: 0)
//        jgen.writeStringField("type", value.type?.name ?: "")
//        jgen.writeStringField("email", value.email ?: "")
//        jgen.writeStringField("status", value.status.name)
//        jgen.writeStringField("name", value.name)
//        jgen.writeObjectField("address", value.address)
//        jgen.writeObjectField("telephones", value.telephones)
        jgen.writeEndObject()
    }
}