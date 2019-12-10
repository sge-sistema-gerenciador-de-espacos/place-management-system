package com.pms.placemanagementsystemserverside.apicontroller.scheduling

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.KeyResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.StatusResponseModel
import com.pms.placemanagementsystemserverside.models.enums.StatusResponseTypeEnum
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.service.scheduling.SchedulingService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/pms-api/scheduler"])
class SchedulingApiController : ApiController<SchedulingModel> {

    private val logger = LoggerFactory.getLogger(SchedulingApiController::class.java)

    @Autowired
    private lateinit var schedulingService: SchedulingService

    override fun create(item: SchedulingModel): ApiResponseModel {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = schedulingService.create(item)
            ApiResponseModel(20000, KeyResponseModel(itemUpdated.id))
        } catch (e: Exception) {
            logger.error("create", e)
            ApiResponseModel()
        }
    }

    override fun readByFilter(item: SchedulingModel): ApiResponseModel {
        var filteredSchedulings: List<SchedulingModel>?

        return try {
            logger.info("readByFilter::item: $item")
            filteredSchedulings = schedulingService.read()
            logger.info("readByFilter::filteredSchedulings: $filteredSchedulings")
            ApiResponseModel()

        } catch (e: Exception) {
            ApiResponseModel()
        }

    }

    override fun read(): ApiResponseModel {
        val schedulingModelList = schedulingService.read()
        logger.info("read::schedulingModelList: $schedulingModelList")
        return ApiResponseModel(20000, schedulingModelList)
    }

    override fun update(item: SchedulingModel, id: Long): ApiResponseModel {
        return try {
            item.id = id
            logger.info("read::update: $item")
            schedulingService.update(item)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseTypeEnum.SUCCESS.status)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    override fun delete(id: Long): ApiResponseModel {
        return try {
            schedulingService.delete(id)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseTypeEnum.SUCCESS.status)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }

    }

}