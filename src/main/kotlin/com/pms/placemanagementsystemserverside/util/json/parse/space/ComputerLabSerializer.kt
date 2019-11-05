package com.pms.placemanagementsystemserverside.util.json.parse.space

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.extensions.oneOrZero
import com.pms.placemanagementsystemserverside.extensions.serializeToInt
import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel

class ComputerLabSerializer(computerLabModel: Class<ComputerLabModel>) : StdSerializer<ComputerLabModel>(computerLabModel) {
    override fun serialize(value: ComputerLabModel, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartObject()
        gen.writeNumber(value.id)
        gen.writeString(value.name)
        gen.writeNumber(value.numberOfChairs)
        gen.writeNumber(value.hasProjector.oneOrZero())
        gen.writeNumber(value.hasBoard.oneOrZero())
        gen.writeNumber(value.hasSmartBoard.oneOrZero())
        gen.writeNumber(value.type.serializeToInt())
        gen.writeNumber(value.numberOfPcs)
        value.softwares.forEach {
            gen.writeObject(it)
        }
        gen.writeEndObject()
    }
}