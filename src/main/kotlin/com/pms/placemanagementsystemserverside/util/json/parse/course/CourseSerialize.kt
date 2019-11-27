package com.pms.placemanagementsystemserverside.util.json.parse.course

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.models.course.CourseModel

class CourseSerialize : StdSerializer<CourseModel> {

    constructor(courseModel: Class<CourseModel>?) : super(courseModel)
    constructor() : this(null)

    override fun serialize(value: CourseModel, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartObject()

        gen.writeNumberField("id", value.id)
        gen.writeStringField("name", value.name)
        gen.writeNumberField("credit", value.credit)
        gen.writeStringField("code", value.code)
        gen.writeObjectField("program", value.program)
        gen.writeNumberField("status", value.status.value)

        gen.writeEndObject()
    }
}