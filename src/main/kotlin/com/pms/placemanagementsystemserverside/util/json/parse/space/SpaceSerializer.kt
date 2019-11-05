package com.pms.placemanagementsystemserverside.util.json.parse.space

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.extensions.oneOrZero
import com.pms.placemanagementsystemserverside.extensions.serializeToInt
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

open class SpaceSerializer(spaceModel: Class<SpaceModel>) : StdSerializer<SpaceModel>(spaceModel) {
    //    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(value: SpaceModel, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartObject()
        gen.writeNumber(value.id)
        gen.writeString(value.name)
        gen.writeNumber(value.numberOfChairs)
        gen.writeNumber(value.hasProjector.oneOrZero())
        gen.writeNumber(value.hasBoard.oneOrZero())
        gen.writeNumber(value.hasSmartBoard.oneOrZero())
        gen.writeNumber(value.type.serializeToInt())
        gen.writeEndObject()
    }
}