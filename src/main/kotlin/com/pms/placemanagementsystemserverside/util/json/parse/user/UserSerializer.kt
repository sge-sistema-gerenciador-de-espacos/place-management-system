package com.pms.placemanagementsystemserverside.util.json.parse.user

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.models.user.UserModel
import java.io.IOException

class UserSerializer : StdSerializer<UserModel> {

    constructor(userModel: Class<UserModel>?) : super(userModel)
    constructor() : this(null)

    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(value: UserModel, jgen: JsonGenerator, provider: SerializerProvider) {
        jgen.writeStartObject()
        jgen.writeNumberField("id", value.id)
        jgen.writeStringField("type", value.type.value)
        jgen.writeStringField("email", value.email)
        jgen.writeNumberField("status", value.status.value)
        jgen.writeStringField("name", value.name)
        jgen.writeStringField("street", value.street)
        jgen.writeStringField("neighborhood", value.neighborhood)
        jgen.writeStringField("city", value.city)
        jgen.writeNumberField("number", value.number)
        jgen.writeNumberField("state", value.state)
        jgen.writeStringField("telephone", value.telephone)
        jgen.writeStringField("password", value.password)
        jgen.writeEndObject()
    }
}