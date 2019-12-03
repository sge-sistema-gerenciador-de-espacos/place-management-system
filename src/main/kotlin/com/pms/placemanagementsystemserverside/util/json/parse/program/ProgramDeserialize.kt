package com.pms.placemanagementsystemserverside.util.json.parse.program

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.extensions.deserializeToActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.program.ProgramModel

class ProgramDeserialize : StdDeserializer<ProgramModel> {

    constructor(programModel: Class<ProgramModel>?) : super(programModel)
    constructor() : this(null)

    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): ProgramModel {
        val jsonNode = jsonParser.codec.readTree<JsonNode>(jsonParser)

        val id = jsonNode.get("id").asLong(0)
        val name = jsonNode.get("name").asText()
        val status = jsonNode.get("status").asInt().deserializeToActivationModelStatusEnum()

        return ProgramModel(id, name, status)
    }
}