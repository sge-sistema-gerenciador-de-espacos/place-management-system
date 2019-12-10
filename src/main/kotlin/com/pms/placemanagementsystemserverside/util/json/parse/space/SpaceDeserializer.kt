package com.pms.placemanagementsystemserverside.util.json.parse.space

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SpaceDeserializer : StdDeserializer<SpaceModel> {

    constructor(spaceModel: Class<SpaceModel>?) : super(spaceModel)
    constructor() : this(null)

    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): SpaceModel {
        val jsonNode = jsonParser.codec.readTree<JsonNode>(jsonParser)

        val id = jsonNode.get("id").asLong(0)
        val name = jsonNode.get("name").asText()

        val spaceItemDto = SpaceItemJsonParser().deserialize(jsonNode)

        return SpaceModel(
                id = id, name = name, numberOfChairs = spaceItemDto.numberOfChairs,
                hasProjector = spaceItemDto.hasProjector, hasBoard = spaceItemDto.hasBoard,
                hasSmartBoard = spaceItemDto.hasSmartBoard, type = spaceItemDto.type, status = spaceItemDto.status,
                numberOfPcs = spaceItemDto.numberOfPcs
        )
    }
}