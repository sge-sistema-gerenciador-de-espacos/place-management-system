package com.pms.placemanagementsystemserverside.apicontroller.clazz

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.KeyResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.StatusResponseModel
import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.service.clazz.ClazzService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
        value = ["/pms-api/clazzs"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class ClazzApiController : ApiController<ClazzModel> {

    private val logger = LoggerFactory.getLogger(ClazzApiController::class.java)

    @Autowired
    private lateinit var clazzService: ClazzService

    override fun create(item: ClazzModel): ApiResponseModel {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = clazzService.create(item)
            ApiResponseModel(20000, KeyResponseModel(itemUpdated.id))
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ApiResponseModel()
        }
    }

    override fun readByFilter(item: ClazzModel): ApiResponseModel {
        var filteredClazzs: List<ClazzModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredClazzs = clazzService.read()
            logger.info("readByFilter::filteredClazzs: $filteredClazzs")
            ApiResponseModel()

        } catch (e: Exception) {
            ApiResponseModel()
        }

    }

    override fun read(): ApiResponseModel {
        val clazzModelList = clazzService.read()
        logger.info("read::clazzModelList: $clazzModelList")
        return ApiResponseModel(20000, clazzModelList)
    }

    override fun update(item: ClazzModel, id: Long): ApiResponseModel {
        return try {
            logger.info("read::update: $item")
            clazzService.update(item)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseModel.StatusResponseTypeEnum.SUCCESS)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    override fun delete(id: Long): ApiResponseModel {
        return try {
            clazzService.delete(id)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseModel.StatusResponseTypeEnum.SUCCESS)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }

    }
}