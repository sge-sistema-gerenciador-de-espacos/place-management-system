package com.pms.placemanagementsystemserverside.util.json.parse.scheduling

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.dto.SpaceItemDto
import com.pms.placemanagementsystemserverside.extensions.deserializeToDayOfWeekEnum
import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.models.enums.SchedulingStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.UserTypeEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.models.scheduling.date.SchedulingDateModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.service.clazz.ClazzService
import com.pms.placemanagementsystemserverside.service.space.SpaceService
import com.pms.placemanagementsystemserverside.service.user.UserService
import com.pms.placemanagementsystemserverside.util.json.parse.space.SpaceItemJsonParser
import org.joda.time.format.DateTimeFormat
import org.springframework.beans.factory.annotation.Autowired

class SchedulingDeserialize : StdDeserializer<SchedulingModel> {

    constructor(schedulingModel: Class<SchedulingModel>?) : super(schedulingModel)
    constructor() : this(null)

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var clazzService: ClazzService

    @Autowired
    private lateinit var spaceService: SpaceService

    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): SchedulingModel {
        val jsonNode = jsonParser.codec.readTree<JsonNode>(jsonParser)
        val users = userService.read()

        val id = jsonNode.get("id").asLong()

        val statusString = jsonNode.get("status").asText()
        val status =
                if (statusString.isNullOrEmpty()) SchedulingStatusEnum.UNKNOWN
                else SchedulingStatusEnum.valueOf(statusString)

        val schedulerId = jsonNode.get("scheduler").get("id").asLong(0)
        val scheduler =
                if (schedulerId != 0L) users.find { it.id == schedulerId }!!
                else UserModel(type = UserTypeEnum.UNKNOWN)

//        val itResponsibleId = jsonNode.get("it_responsable").get("id").asLong(0)
//        val itResponsible =
//                if (itResponsibleId != 0L) users.find { it.id == itResponsibleId }!!
//                else UserModel(type = UserTypeEnum.IT_SUPPORT)

//        val itResponsibleMsg = jsonNode.get("it_responsible_msg").asText()

        val clazzId = jsonNode.get("classes").get("id").asLong()
        val clazz =
                if (clazzId != 0L) clazzService.read().findLast { it.id == clazzId }!!
                else ClazzModel()

//        val assistentId = jsonNode.get("")
//        val assistent = users.find { it.id == id }

//        val assistentMsg = jsonNode.get("")

        val professorId = jsonNode.get("professor").get("id").asLong(0)
        val professor =
                if (professorId != 0L) users.find { it.id == professorId }!!
                else UserModel(type = UserTypeEnum.PROFESSOR)

        val startTimeString = jsonNode.get("initialtime").asText()
        val endTimeString = jsonNode.get("endtime").asText()

        val timeFormat = DateTimeFormat.forPattern("HH:mm");
        val startTime = timeFormat.parseDateTime(startTimeString)
        val endTime = timeFormat.parseDateTime(endTimeString)

        val filterDateJsonNodeArray = jsonNode.withArray("filterdate")
        val startDateString = filterDateJsonNodeArray[0].asText()
        val endDateString = filterDateJsonNodeArray[1].asText()

        val dayOfWeekEnum = jsonNode.get("weekDay").asInt().deserializeToDayOfWeekEnum()

        val dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd")
        val startDateTime = dateFormat.parseDateTime(startDateString)
        val endDateTime = dateFormat.parseDateTime(endDateString)

        val schedulingDateModelList = mutableListOf<SchedulingDateModel>()
        var referredDay = startDateTime

        while (referredDay.isBefore(endDateTime)) {
            if (referredDay.dayOfWeek == dayOfWeekEnum.dateTimeConstants) {
                schedulingDateModelList.add(
                        SchedulingDateModel(
                                startTime = startTime, endTime = endTime, date = referredDay
                        )
                )
            }
            referredDay = referredDay.plusDays(1)
        }

        val spaceId = jsonNode.get("space").get("id").asLong(0)
        var spaceModelFound = SpaceModel()
        var spaceItemDto = SpaceItemDto()

        if (spaceId != 0L) {
            spaceModelFound = spaceService.read().find { it.id == spaceId }!!
        } else {
            SpaceModel()
            spaceItemDto = SpaceItemJsonParser().deserialize(jsonNode.get("space_item"))
        }

        return SchedulingModel(
                id = id, status = status, schedulingDateModels = schedulingDateModelList,
                clazz = clazz, professor = professor, schedulerUser = scheduler, spaceFound = spaceModelFound,
                hasProjector = spaceItemDto.hasProjector, numberOfChairs = spaceItemDto.numberOfChairs,
                hasBoard = spaceItemDto.hasBoard, hasSmartBoard = spaceItemDto.hasSmartBoard,
                numberOfPcs = spaceItemDto.numberOfPcs, spaceType = spaceItemDto.type
        )
    }
}