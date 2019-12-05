package com.pms.placemanagementsystemserverside.util.json.parse.clazz

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel

class ClazzSerialize : StdSerializer<ClazzModel> {

    constructor(clazzModel: Class<ClazzModel>?) : super(clazzModel)
    constructor() : this(null)

    override fun serialize(value: ClazzModel, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartObject()

        gen.writeNumberField("id", value.id)
        gen.writeNumberField("status", value.status.value)
        gen.writeStringField("name", value.name)
        gen.writeObjectField("course", value.course)
        gen.writeObjectField("master", value.professor)

        gen.writeEndObject()
    }

}