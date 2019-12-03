package com.pms.placemanagementsystemserverside.util.json.parse.program

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.program.ProgramModel

class ProgramSerialize : StdSerializer<ProgramModel> {

    constructor(programModel: Class<ProgramModel>?) : super(programModel)
    constructor() : this(null)

    override fun serialize(value: ProgramModel, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartObject()

        gen.writeNumberField("id", value.id)
        gen.writeStringField("name", value.name)
        gen.writeNumberField("status", value.status.value)

        gen.writeEndObject()
    }
}