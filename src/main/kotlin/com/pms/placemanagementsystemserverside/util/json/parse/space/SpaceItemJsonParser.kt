package com.pms.placemanagementsystemserverside.util.json.parse.space

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.pms.placemanagementsystemserverside.dto.SpaceItemDto
import com.pms.placemanagementsystemserverside.extensions.deserializeToActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.extensions.deserializeToSpaceEnumType
import com.pms.placemanagementsystemserverside.extensions.oneOrZero
import com.pms.placemanagementsystemserverside.extensions.trueOrFalse
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SpaceItemJsonParser {

    fun serialize(value: SpaceModel, gen: JsonGenerator) {
        gen.writeStartObject()

        gen.writeNumberField("numberChair", value.numberOfChairs)
        gen.writeNumberField("project", value.hasProjector.oneOrZero())
        gen.writeNumberField("board", value.hasBoard.oneOrZero())
        gen.writeNumberField("smartBoard", value.hasSmartBoard.oneOrZero())
        gen.writeStringField("type", value.type.value)
        gen.writeNumberField("status", value.status.value)
        gen.writeNumberField("numberPc", value.numberOfPcs)

        gen.writeEndObject()
    }

    fun deserialize(jsonNode: JsonNode): SpaceItemDto {

        val numberOfChairs = jsonNode.get("numberChair").asInt()
        val hasProjector = jsonNode.get("project").asInt().trueOrFalse()
        val hasBoard = jsonNode.get("board").asInt().trueOrFalse()
        val hasSmartBoard = jsonNode.get("smartBoard").asInt().trueOrFalse()
        val type = jsonNode.get("type").asText().deserializeToSpaceEnumType()
        val status = jsonNode.get("status").asInt().deserializeToActivationModelStatusEnum()
        val numberOfPcs = jsonNode.get("numberPc").asInt()

        return SpaceItemDto(
                numberOfChairs = numberOfChairs, hasProjector = hasProjector, hasBoard = hasBoard,
                hasSmartBoard = hasSmartBoard, type = type, status = status, numberOfPcs = numberOfPcs
        )
    }

}