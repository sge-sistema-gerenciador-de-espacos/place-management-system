package com.pms.placemanagementsystemserverside.util.json.parse.scheduling

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel

class SchedulingSerialize : StdSerializer<SchedulingModel> {

    constructor(schedulingModel: Class<SchedulingModel>?) : super(schedulingModel)
    constructor() : this(null)

    override fun serialize(value: SchedulingModel, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartObject()

        gen.writeNumberField("id", value.id)
        gen.writeStringField("status", value.status.name)
        gen.writeObjectField("scheduler", value.schedulerUser)
        gen.writeObjectField("it_responsible", value.itResponsible)
        gen.writeStringField("it_responsible_msg", value.itResponsibleMsg)
        gen.writeObjectField("classes", value.clazz)
        gen.writeObjectField("assistent", value.assistent)
        gen.writeObjectField("professor", value.professor)
//        schedulingDateModels //TODO acertar

        gen.writeEndObject()
    }
}