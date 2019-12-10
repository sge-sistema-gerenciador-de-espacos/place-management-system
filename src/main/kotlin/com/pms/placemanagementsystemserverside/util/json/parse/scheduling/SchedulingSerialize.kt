package com.pms.placemanagementsystemserverside.util.json.parse.scheduling

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.util.json.parse.space.SpaceItemJsonParser

class SchedulingSerialize : StdSerializer<SchedulingModel> {

    constructor(schedulingModel: Class<SchedulingModel>?) : super(schedulingModel)
    constructor() : this(null)

    override fun serialize(value: SchedulingModel, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartObject()

        gen.writeNumberField("id", value.id)
        gen.writeStringField("status", value.status.name)

        //TODO converter pra pegar dia da semana
//        gen.writeNumberField("weekDay", value.schedulingDateModels[0].)

        gen.writeObjectField("classes", value.clazz)
        gen.writeObjectField("space", value.spaceFound)

        val spaceItem = SpaceModel(
                numberOfPcs = value.numberOfPcs, numberOfChairs = value.numberOfChairs,
                hasSmartBoard = value.hasSmartBoard, hasBoard = value.hasBoard, hasProjector = value.hasProjector,
                type = value.spaceType
        )

        SpaceItemJsonParser().serialize(spaceItem, gen)
        gen.writeObjectField("professor", value.professor)
        gen.writeObjectField("it_responsible", value.itResponsible)
        gen.writeObjectField("scheduler", value.schedulerUser)
        gen.writeObjectField("acceptor", value.assistent)

        gen.writeEndObject()
    }
}