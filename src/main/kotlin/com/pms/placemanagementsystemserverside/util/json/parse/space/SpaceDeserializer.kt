package com.pms.placemanagementsystemserverside.util.json.parse.space

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.extensions.deserializeToActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.extensions.deserializeToSpaceEnumType
import com.pms.placemanagementsystemserverside.extensions.trueOrFalse
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SpaceDeserializer : StdDeserializer<SpaceModel> {

    constructor(spaceModel: Class<SpaceModel>?) : super(spaceModel)
    constructor() : this(null)

    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): SpaceModel {
        val jsonNode = jsonParser.codec.readTree<JsonNode>(jsonParser)

        val id = jsonNode.get("id").asLong(0)
        val name = jsonNode.get("name").asText()
        val numberOfChairs = jsonNode.get("numberChair").asInt()
        val hasProjector = jsonNode.get("project").asInt().trueOrFalse()
        val hasBoard = jsonNode.get("board").asInt().trueOrFalse()
        val hasSmartBoard = jsonNode.get("smartBoard").asInt().trueOrFalse()
        val type = jsonNode.get("type").asText().deserializeToSpaceEnumType()
        val status = jsonNode.get("status").asInt().deserializeToActivationModelStatusEnum()
        val numberOfPcs = jsonNode.get("numberPc").asInt()

        return SpaceModel(
                id = id, name = name, numberOfChairs = numberOfChairs, hasProjector = hasProjector,
                hasBoard = hasBoard, hasSmartBoard = hasSmartBoard,
                type = type, status = status, numberOfPcs = numberOfPcs
        )
    }
}