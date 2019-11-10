package com.pms.placemanagementsystemserverside.util.json.parse.space

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.extensions.isComputerLab
import com.pms.placemanagementsystemserverside.extensions.oneOrZero
import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import java.io.IOException

class SpaceSerializer : StdSerializer<SpaceModel> {

    constructor(spaceModel: Class<SpaceModel>?) : super(spaceModel)
    constructor() : this(null)

    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(value: SpaceModel, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartObject()
        gen.writeNumber(value.id)
        gen.writeString(value.name)
        gen.writeNumber(value.numberOfChairs)
        gen.writeNumber(value.hasProjector.oneOrZero())
        gen.writeNumber(value.hasBoard.oneOrZero())
        gen.writeNumber(value.hasSmartBoard.oneOrZero())
        gen.writeNumber(value.type.value)
        gen.writeNumber(value.status.value)

        if (value.type.isComputerLab()) {
            val computerLab = value as ComputerLabModel
            gen.writeNumber(computerLab.numberOfPcs)
        }

        gen.writeEndObject()
    }
}