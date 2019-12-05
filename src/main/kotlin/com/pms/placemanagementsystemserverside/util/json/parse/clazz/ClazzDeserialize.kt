package com.pms.placemanagementsystemserverside.util.json.parse.clazz

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.extensions.deserializeToActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.service.course.CourseService
import com.pms.placemanagementsystemserverside.service.user.UserService
import org.springframework.beans.factory.annotation.Autowired

class ClazzDeserialize : StdDeserializer<ClazzModel> {

    constructor(clazzModel: Class<ClazzModel>?) : super(clazzModel)
    constructor() : this(null)

    @Autowired
    lateinit var courseService: CourseService

    @Autowired
    lateinit var userService: UserService

    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): ClazzModel {
        val jsonNode = jsonParser.codec.readTree<JsonNode>(jsonParser)

        val id = jsonNode.get("id").asLong()
        val status = jsonNode.get("status").asInt().deserializeToActivationModelStatusEnum()
        val name = jsonNode.get("name").asText()

        val courseId = jsonNode.get("course").get("id").asLong()
        val course = courseService.read().find { it.id == courseId }!!

        val professorId = jsonNode.get("master").get("id").asLong()
        val professor = userService.read().find { it.id == professorId }!!

        return ClazzModel(id = id, status = status, name = name, course = course, professor = professor)
    }


}