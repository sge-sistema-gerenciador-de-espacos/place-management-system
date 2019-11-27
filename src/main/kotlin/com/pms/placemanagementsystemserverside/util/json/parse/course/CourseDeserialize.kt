package com.pms.placemanagementsystemserverside.util.json.parse.course

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.extensions.deserializeToActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.course.CourseModel
import com.pms.placemanagementsystemserverside.service.program.ProgramService
import org.springframework.beans.factory.annotation.Autowired

class CourseDeserialize : StdDeserializer<CourseModel> {

    constructor(courseModel: Class<CourseModel>?) : super(courseModel)
    constructor() : this(null)

    @Autowired
    private lateinit var programService: ProgramService

    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): CourseModel {
        val jsonNode = jsonParser.codec.readTree<JsonNode>(jsonParser)

        val id = jsonNode.get("id").asLong(0)
        val name = jsonNode.get("name").asText()
        val credit = jsonNode.get("credit").asInt()
        val code = jsonNode.get("code").asText()
        val programId = jsonNode.get("program").get("id").asLong(0)
        val program = programService.read().filter { it.id == programId }[0]
        val status = jsonNode.get("status").asInt().deserializeToActivationModelStatusEnum()

        return CourseModel(id, name, credit, code, program, status)
    }
}