package com.pms.placemanagementsystemserverside.util.json.parse.scheduling

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.extensions.deserializeToDayOfWeekEnum
import com.pms.placemanagementsystemserverside.models.enums.SchedulingStatusEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDateModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.service.clazz.ClazzService
import com.pms.placemanagementsystemserverside.service.user.UserService
import com.pms.placemanagementsystemserverside.util.json.parse.space.SpaceDeserializer
import org.joda.time.format.DateTimeFormat
import org.springframework.beans.factory.annotation.Autowired

class SchedulingDeserialize : StdDeserializer<SchedulingModel> {

    constructor(schedulingModel: Class<SchedulingModel>?) : super(schedulingModel)
    constructor() : this(null)

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var clazzService: ClazzService

    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): SchedulingModel {
        val jsonNode = jsonParser.codec.readTree<JsonNode>(jsonParser)
        val users = userService.read()

        val id = jsonNode.get("id").asLong()
        val status = SchedulingStatusEnum.valueOf(jsonNode.get("status").asText())

        val schedulerId = jsonNode.get("scheduler").get("id").asLong()
        val scheduler = users.find { it.id == schedulerId }!!

        val itResponsibleId = jsonNode.get("it_responsible").get("id").asLong()
        val itResponsible = users.find { it.id == itResponsibleId }!!

//        val itResponsibleMsg = jsonNode.get("it_responsible_msg").asText()

        val clazzId = jsonNode.get("classes").get("id").asLong()
        val clazz = clazzService.read().findLast { it.id == clazzId }!!

//        val assistentId = jsonNode.get("")
//        val assistent = users.find { it.id == id }

//        val assistentMsg = jsonNode.get("")

        val professorId = jsonNode.get("professor").get("id").asLong()
        val professor = users.find { it.id == professorId }!!

        val spaceToFind = SpaceDeserializer(SpaceModel::class.java).deserialize(jsonParser, ctxt)

        val startTimeString = jsonNode.get("start_time").asText()
        val endTimeString = jsonNode.get("end_time").asText()
        val filterDateJsonNodeArray = jsonNode.withArray("filter_date")
        val startDateString = filterDateJsonNodeArray[0].asText()
        val endDateString = filterDateJsonNodeArray[1].asText()
        val dayOfWeekEnum = jsonNode.get("weekDay").asInt().deserializeToDayOfWeekEnum()

//        val dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        val dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd");
        val startDateTime = dateFormat.parseDateTime("$startDateString $startTimeString")
        val endDateTime = dateFormat.parseDateTime("$endDateString $endTimeString")

        val schedulingDateModelList = mutableListOf<SchedulingDateModel>()
        var starDateTimeToUseInRage = startDateTime

        while (starDateTimeToUseInRage.isBefore(endDateTime)) {
            if (starDateTimeToUseInRage.dayOfWeek == dayOfWeekEnum.dateTimeConstants) {
                schedulingDateModelList.add(
                        SchedulingDateModel(
                                startTime = startDateTime, endTime = endDateTime, date = starDateTimeToUseInRage,
                                space = spaceToFind
                        )
                )
            }
            starDateTimeToUseInRage = starDateTimeToUseInRage.plusDays(1)
        }

        return SchedulingModel(
                id = id, status = status, schedulerUser = scheduler, schedulingDateModels = schedulingDateModelList,
                clazz = clazz, professor = professor
        )
    }
}