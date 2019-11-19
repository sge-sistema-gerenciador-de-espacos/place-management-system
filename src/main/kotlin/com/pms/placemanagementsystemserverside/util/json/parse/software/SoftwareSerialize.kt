package com.pms.placemanagementsystemserverside.util.json.parse.software

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel

class SoftwareSerialize : StdSerializer<SoftwareModel> {

    constructor(softwareModel: Class<SoftwareModel>?) : super(softwareModel)
    constructor() : this(null)

    override fun serialize(value: SoftwareModel, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartObject()
        gen.writeNumberField("id", value.id)
        gen.writeStringField("name", value.name)
        gen.writeNumberField("status", value.status.value)
        gen.writeEndObject()
    }
}