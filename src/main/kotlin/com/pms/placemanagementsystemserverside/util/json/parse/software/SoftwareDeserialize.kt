package com.pms.placemanagementsystemserverside.util.json.parse.software

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.extensions.deserializeToActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel

class SoftwareDeserialize : StdDeserializer<SoftwareModel> {

    constructor(softwareModel: Class<SoftwareModel>?) : super(softwareModel)
    constructor() : this(null)

    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext?): SoftwareModel {
        val jsonNode = jsonParser.codec.readTree<JsonNode>(jsonParser)
        val id = jsonNode.get("id").asLong()
        val name = jsonNode.get("name").asText()
        val status = jsonNode.get("status").asInt().deserializeToActivationModelStatusEnum()
        return SoftwareModel(id, name, status)
    }
}